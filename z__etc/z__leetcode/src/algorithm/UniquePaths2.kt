package algorithm

class UniquePaths2 {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val m = obstacleGrid.size
        val n = obstacleGrid[0].size

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0
                    continue
                }
                // Blocked would be not care.

                if (i == 0 && j == 0) {
                    obstacleGrid[0][0] = 1
                } else if (i == 0) {
                    obstacleGrid[0][j] = obstacleGrid[0][j - 1]
                } else if (j == 0) {
                    obstacleGrid[i][0] = obstacleGrid[i - 1][0]
                } else {
                    obstacleGrid[i][j] =  obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]
                }
            }
        }

        return obstacleGrid[m - 1][n - 1]
    }
}