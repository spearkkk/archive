package algorithm

class UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        val board = Array(m + 1) { IntArray(n + 1) }

        for (i in 1 .. m) {
            for (j in 1 .. n) {
                if (i == 1 || j == 1) {
                    board[i][j] = 1
                    continue
                }
                board[i][j] = board[i - 1][j] + board[i][j - 1]
            }
        }

        return board[m][n]
    }
}