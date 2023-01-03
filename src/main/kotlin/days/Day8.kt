package days

class Day8 : Day(8) {

    override fun partOne(): Any {
        var visibleCount = inputList.count() * 2 + ( inputList.first().length -2 ) * 2
        val values = mutableListOf<String>()
        for (row in 1 until inputList.lastIndex) {
            for (position in 1 until (inputList.get(row).length - 1)) {
                if(isVisible(row, position)) {
                    val height = inputList.get(row)[position].toString().toInt()
                    values.add(inputList.get(row)[position].toString())
                    visibleCount++
                }
            }
        }
        return (visibleCount).toString()
    }

    private fun isVisible(row: Int, position: Int) : Boolean {
        return isVisibleDown(row, position) or isVisibleUp(row, position) or isVisibleLeft(row, position) or isVisibleRight(row, position)
    }

    private fun getViewableProduct(row: Int, position: Int) : Int {
        val product = visibleDistanceDown(row, position) * visibleDistanceUp(row, position) * visibleDistanceLeft(row, position) * visibleDistanceRight(row, position)
        return product
    }

    private fun isVisibleLeft(row: Int, position: Int) : Boolean {
        val height = inputList.get(row)[position].toString().toInt()
        for (x in 0 until position) {
            if(inputList.get(row)[x].toString().toInt() >= height) {
                return false
            }
        }

        return true
    }

    private fun isVisibleRight(row: Int, position: Int) : Boolean {
        val height = inputList.get(row)[position].toString().toInt()
        for (x in position+1 until inputList.get(row).length) {
            if(inputList.get(row)[x].toString().toInt() >= height) {
                return false
            }
        }

        return true
    }

    private fun isVisibleUp(row: Int, position: Int) : Boolean {
        val height = inputList.get(row)[position].toString().toInt()
        for (x in 0 until row) {
            if(inputList.get(x)[position].toString().toInt() >= height) {
                return false
            }
        }

        return true
    }

    private fun isVisibleDown(row: Int, position: Int) : Boolean {
        val height = inputList.get(row)[position].toString().toInt()
        for (x in row+1 until inputList.count()) {
            if(inputList.get(x)[position].toString().toInt() >= height) {
                return false
            }
        }

        return true
    }

    private fun visibleDistanceLeft(row: Int, position: Int) : Int {
        val height = inputList.get(row)[position].toString().toInt()
        var distance = 0
        for (x in position-1 downTo 0) {
            distance++
            if(inputList.get(row)[x].toString().toInt() >= height) {
                return distance
            }
        }

        return distance
    }


    private fun visibleDistanceRight(row: Int, position: Int) : Int {
        val height = inputList.get(row)[position].toString().toInt()
        var distance = 0
        for (x in position+1 until inputList.get(row).length) {
            distance++
            if(inputList.get(row)[x].toString().toInt() >= height) {
                return distance
            }
        }

        return distance
    }

    private fun visibleDistanceUp(row: Int, position: Int) : Int {
        val height = inputList.get(row)[position].toString().toInt()
        var distance = 0
        for (x in row-1 downTo  0) {
            distance++
            if(inputList.get(x)[position].toString().toInt() >= height) {
                return distance
            }
        }

        return distance
    }

    private fun visibleDistanceDown(row: Int, position: Int) : Int {
        val height = inputList.get(row)[position].toString().toInt()
        var distance = 0
        for (x in row+1 until inputList.count()) {
            distance++
            if(inputList.get(x)[position].toString().toInt() >= height) {
                return distance
            }
        }

        return distance
    }

    override fun partTwo(): Any {
        var maxViewableProduct = 0
        for (row in 1 until inputList.lastIndex) {
            for (position in 1 until (inputList.get(row).length - 1)) {
                val viewableProduct = getViewableProduct(row, position)
                val height = inputList.get(row)[position].toString().toInt()

                if (viewableProduct > maxViewableProduct) {
                    maxViewableProduct = viewableProduct
                }
            }
        }
        return (maxViewableProduct).toString()
    }
}