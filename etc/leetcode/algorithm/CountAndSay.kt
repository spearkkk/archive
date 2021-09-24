package algorithm

/**
 * 앞의 값과 달라지는 순간 잘라서 count and say 룰 한다.
 */
class CountAndSay {
    private fun split(nums: IntArray): IntArray {
        var cursor = 0
        var count = 0
        var currentValue = nums[cursor]

        val holder: MutableList<Int> = mutableListOf<Int>()

        while (cursor < nums.size) {
            if (nums[cursor] == currentValue) {
                count += 1
                cursor += 1
            } else {
                holder.add(count)
                holder.add(currentValue)

                count = 0
                currentValue = nums[cursor]
            }
        }

        if (count != 0) {
            holder.add(count)
            holder.add(currentValue)
        }

        return holder.toIntArray()
    }

    fun countAndSay(n: Int): String {
        if (n == 1) {
            return "1"
        }

        var nums = intArrayOf(1)
        for (i in 2..n) {
            nums = split(nums)
        }
        return nums.joinToString("") { i -> i.toString() }
    }
}