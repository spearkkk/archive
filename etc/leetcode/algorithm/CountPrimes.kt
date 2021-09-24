package algorithm

import kotlin.math.sqrt

/**
 * 에라토스테네스의 체
 */
class CountPrimes {
    private fun isPrime(n: Int): Boolean {
        for (i in 2 .. sqrt(n.toFloat()).toInt()) {
            if (n % i == 0) {
                return false
            }
        }
        return true
    }

    fun countPrimes(n: Int): Int {
        if (n <= 1) {
            return 0
        }

        var count = 0
        for (i in 2 until n) {
            if (isPrime(i)) {
                count += 1
            }
        }

        return count
    }
}