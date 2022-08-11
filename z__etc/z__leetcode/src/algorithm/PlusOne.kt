package algorithm

/// https://leetcode.com/problems/plus-one/
class PlusOne {

    fun plusOne(digits: IntArray): IntArray {
        val result = intArrayOf(0) + digits.copyOf()
        var carry = 1

        for (i in result.indices.reversed()) {
            if (carry < 1) {
                break
            }

            val tmp = result[i] + 1

            result[i] = tmp % 10
            carry = tmp / 10
        }

        return if (result[0] != 0) result else result.sliceArray(1 until result.size)
    }
}
