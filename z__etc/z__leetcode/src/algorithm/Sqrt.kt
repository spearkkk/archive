package algorithm

/// https://leetcode.com/problems/sqrtx
class Sqrt {

    fun mySqrt(x: Int): Int {
        if (x < 2) {
            return x
        }

        var result = 1L

        while ((result + 1) * (result + 1) <= x) {
            result += 1L
        }

        return result.toInt()
    }
}
