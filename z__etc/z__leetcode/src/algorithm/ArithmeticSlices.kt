package algorithm

/// https://leetcode.com/problems/arithmetic-slices/
class ArithmeticSlices {

    fun numberOfArithmeticSlices(nums: IntArray): Int {
        if (nums.size <= 2) {
            return 0
        }

        val holder = IntArray(nums.size) { Int.MAX_VALUE }

        /// 뒤에 위치한 값이랑 빼서 저장한다.
        for (i in 0 until nums.size - 1) {
            holder[i] = nums[i + 1] - nums[i]
        }

        var sum = 0
        var i = 0
        var count = 0

        /**
         * 뺀 값이 연속되어 있는 수를 카운팅하고, 그 수에서 만들어지는 서브 배열의 수를 찾는다.
         * 연속되지 않았을 경우 초기화해서 다시 카운팅한다.
         */
        while (i < holder.size - 1) {
            if (holder[i] == holder[i + 1]) {
                count += 1
                i += 1
                continue
            }

            if (count >= 1) {
                sum += (1 .. count).sum()
            }
            count = 0
            i += 1
        }

        return sum
    }
}
