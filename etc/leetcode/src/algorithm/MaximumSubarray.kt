package algorithm

class MaximumSubarray {
    fun maxSubArray(nums: IntArray): Int {
        val sum: MutableList<Int> = MutableList(nums.size) { -100001 }

        for (i in nums.indices) {
            if (i == 0) {
                sum[0] = nums[0]
                continue
            }

            if (sum[i - 1] + nums[i] < nums[i]) {
                sum[i] = nums[i]
            } else {
                sum[i] = sum[i - 1] + nums[i]
            }
        }

        return sum.maxOrNull()!!
    }
}