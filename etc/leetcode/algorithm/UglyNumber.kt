package algorithm

class UglyNumber {
    fun isUgly(n: Int): Boolean {
        if (n <= 0) {
            return false
        }

        var tmp = n
        do {
            if (tmp == 1) {
                return true
            }

            if (tmp % 2 == 0) {
                tmp /= 2
                continue
            }
            if (tmp % 3 == 0) {
                tmp /= 3
                continue
            }
            if (tmp % 5 == 0) {
                tmp /= 5
                continue
            }
            return false
        } while (tmp > 1)
        return true
    }
}