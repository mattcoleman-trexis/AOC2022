package days

class Day4 : Day(4) {

    override fun partOne(): Any {
        val overlaps = inputList.filter {
            val elves = it.split(',').map { s ->
                val parts = s.split('-')
                Sections(parts.first().toInt(), parts.last().toInt())
            }
            (elves.first().isFullOverlap(elves.last()))
        }.count()

        return overlaps.toString()
    }

    override fun partTwo(): Any {
        val overlaps = inputList.filter {
            val elves = it.split(',').map { s ->
                val parts = s.split('-')
                Sections(parts.first().toInt(), parts.last().toInt())
            }
            (elves.first().isAnyOverlap(elves.last()))
        }.count()

        return overlaps.toString()
    }

    data class Sections(
        val start: Int,
        val stop: Int
    ) {
        fun isFullOverlap(s: Sections): Boolean {
            return this.isFullOverlapFrom(s) || s.isFullOverlapFrom(this)
        }

        private fun isFullOverlapFrom(s: Sections): Boolean {
            return this.start >= s.start && this.stop <= s.stop
        }

        fun isAnyOverlap(s: Sections): Boolean {
            return this.isAnyOverlapFrom(s) || s.isAnyOverlapFrom(this)
        }

        private fun isAnyOverlapFrom(s: Sections): Boolean {
            return this.start >= s.start && this.start <= s.stop || this.stop <= s.stop && this.stop >= s.start
        }
    }
}
