package algorithm

class MaximalSquare {
    // area 값을 저장하지 않고 정사각형의 한 변의 길이를 저장한다.
    fun maximalSquare(matrix: Array<CharArray>): Int {
        var max = 0

        val holder: Array<IntArray> = Array<IntArray>(matrix.size) { IntArray( matrix[0].size ) { 0 } }

        for (i in matrix.indices) {
            holder[i] = matrix[i].map{ it.toInt() - 48 }.toIntArray()
        }

        for (i in matrix.indices) {
            if (holder[i][0] == 1) {
                max = 1
                break
            }
        }

        for (i in matrix[0].indices) {
            if (holder[0][i] == 1) {
                max = 1
                break
            }

        }

        for (i in 1 until matrix.size) {
            for (j in 1 until matrix[i].size) {
                val rightBottom = holder[i][j]
                val leftTop = holder[i - 1][j - 1]
                val leftBottom = holder[i][j - 1]
                val rightTop = holder[i - 1][j]

                if (rightBottom == 0 || rightTop == 0 || leftBottom == 0 || leftTop == 0) {
                    // edge case
                    if (rightBottom == 1) {
                        if (max < rightBottom) {
                            max = rightBottom
                        }
                    }
                    continue
                }


                val tmp = kotlin.math.min(kotlin.math.min(rightTop, leftTop), leftBottom) + 1
                if (tmp > max) {
                    max = tmp
                }
                holder[i][j] = tmp
            }
        }
        return max * max
    }
}