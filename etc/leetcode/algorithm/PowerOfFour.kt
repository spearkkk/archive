package algorithm

class PowerOfFour {
    fun isPowerOfFour(n: Int): Boolean {
        if (n <= 0) {
            return false
        }

        var flag = false
        for (i in 0 .. 31) {
            if (n.and(1.shl(i)) != 0) {
                if (i % 2 == 0 && !flag) {
                    flag = !flag
                    continue
                }
                return false
            }
        }

        return true
    }
}