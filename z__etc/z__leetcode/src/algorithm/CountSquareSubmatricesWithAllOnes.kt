package algorithm

class CountSquareSubmatricesWithAllOnes {

    fun countSquares(matrix: Array<IntArray>): Int {
        val holder = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) { 0 } }

        for (y in matrix.indices) {
            for (x in matrix[y].indices) {
                holder[y + 1][x + 1] = matrix[y][x]
            }
        }

        for (y in 1 until holder.size) {
            for (x in 1 until holder[y].size) {

                val cur = holder[y][x]
                if (cur == 0) {
                    continue
                }

                val diagonal = holder[y - 1][x - 1]
                val left = holder[y][x - 1]
                val top = holder[y - 1][x]

                val min = Math.min(Math.min(diagonal, left), top)
                if (min == 0) {
                    continue
                }

                holder[y][x] = 1 + min
            }
        }

        var sum = 0
        for (y in 1 until holder.size) {
            for (x in 1 until holder[y].size) {
                sum += holder[y][x]
            }
        }


        return sum
    }
}
