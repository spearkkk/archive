package algorithm

/// https://leetcode.com/problems/count-square-submatrices-with-all-ones/
class CountSquareSubmatricesWithAllOnes {
    fun countSquares(matrix: Array<IntArray>): Int {
        /**
         * 새롭게 매트릭스 생성한다.
         * 계산하기 쉽게 첫번째는 0으로 초기화해서 만든다.
         */
        val holder = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) { 0 } }

        /// 복사
        for (y in matrix.indices) {
            for (x in matrix[y].indices) {
                holder[y + 1][x + 1] = matrix[y][x]
            }
        }

        /**
         * 새로운 매트릭스의 0번째 인덱스는 0으로 임의로 초기화한 것이라 스킵
         * (1, 1) 부터 시작해서 자기 자신, 대각선, 왼쪽, 위쪽의 값을 체크한다.
         * 자기 자신이 1이고 나머지 3곳의 최소값을 구해 자신의 값을 갱신한다.
         * 즉, 현재 포지션에서 최대로 가질 수 있는 정사각형 값을 갱신한다.
         */
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
