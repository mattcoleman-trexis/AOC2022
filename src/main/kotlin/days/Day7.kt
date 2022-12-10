package days

class Day7 : Day(7) {
    val rootDirectory = FileSystemRecord(type = FileType.DIRECTORY, path = "/", name = "", parent = null)
    var fileSystemList: MutableList<FileSystemRecord> = mutableListOf(rootDirectory)
    var workingDirectory: FileSystemRecord = rootDirectory

    override fun partOne(): Any {
        parseCommands()
        val sum = fileSystemList.filter { it.type == FileType.DIRECTORY }.map { getTotalSize(it) }.filter { it < 100000}.sum()
        return sum.toString()
    }

    private fun parseCommands() {
        inputList.forEach { s ->
            val split = s.split(" ")
            val (arg, command) = split
            when (arg) {
                "$" -> when (command) {
                    "cd" -> {
                        val directoryName = if (split.count() > 2) {
                            split[2]
                        } else {
                            null
                        }

                        if (directoryName == ".." && workingDirectory.parent != null) {
                            workingDirectory = workingDirectory.parent!!
                        } else if (directoryName != null && directoryName != "/") {
                            val newDirectory = FileSystemRecord(
                                type = FileType.DIRECTORY,
                                path = (workingDirectory.path) + directoryName + "/",
                                name = directoryName,
                                parent = workingDirectory
                            )
                            fileSystemList.add(newDirectory)
                            workingDirectory = newDirectory
                        }
                    }
                }
                "dir" -> {}
                else -> {

                    val (size, filename) = s.split(" ")

                    fileSystemList.add(
                        FileSystemRecord(
                            type = FileType.FILE,
                            path = workingDirectory.path + filename,
                            name = filename,
                            parent = workingDirectory,
                            size = size.toLong()
                        )
                    )
                    fileSystemList
                }

            }
        }
    }

    override fun partTwo(): Any {
        val total = getTotalSize(fileSystemList.first())
        val needFree = 30000000 - (70000000 - total)
        val deleteAmount = fileSystemList.filter { it.type == FileType.DIRECTORY }.map { getTotalSize(it) }.filter { it > needFree}
            .sorted().first()

        return deleteAmount.toString()
    }

    enum class FileType {
        DIRECTORY,
        FILE
    }

    data class FileSystemRecord(
        val type: FileType,
        val path: String,
        val size: Long = 0,
        val name: String,
        val parent: FileSystemRecord? = null
    )

    private fun getTotalSize(directory: FileSystemRecord) : Long {
        val sum = fileSystemList.filter { it.type == FileType.FILE  && it.path.contains(directory.path)}.map {it.size}.sum()
        return sum
    }
}