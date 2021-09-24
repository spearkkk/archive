package algorithm

/**
 * 계속해서 반복하다가 자신이 지나왔던 길이면 무한 루프로 빠진다.
 * 즉, 절대 happy number 가 될 수 없다.
 * https://en.wikipedia.org/wiki/Happy_number
 */
class HappyNumber {
    private fun makeItHappy(n: Int): Int {
        var tmp = n
        var sum = 0

        while (tmp >= 10) {
            val remainder = tmp % 10
            sum += remainder * remainder

            tmp /= 10
        }

        return sum + tmp * tmp
    }

    fun isHappy(n: Int): Boolean {
        var candidate = n
        val holder = hashSetOf<Int>()

        do {
            candidate = makeItHappy(candidate)
            if (holder.contains(candidate)) {
                break
            }
            holder.add(candidate)
        } while (candidate != 1)

        if (candidate == 1) {
            return true
        }

        return false
    }
}