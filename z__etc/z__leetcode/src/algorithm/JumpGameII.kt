package algorithm

class JumpGameII {
    private fun doJumping(current: Int, tried: IntArray, nums: IntArray): Int {
        if (current < 0) {
            // end
            return tried[0]
        }

        val maximum: Int = nums[current]

        if (maximum == 0) {
            // cannot jump
            tried[current] = 10001
            return doJumping(current - 1, tried, nums)
        }

        val goal: Int = nums.size - 1

        if ((maximum + current) >= goal) {
            // can jump to last index(goal)
            tried[current] = 1
        } else {
            // cannot jump to last index(goal)
            // find minimum jump site and jump(+1)
            tried[current] = ((1 .. maximum).map { current + it }.filter { it < tried.size }.map { tried[it] }.minOrNull() ?: 10001) + 1
        }
        return doJumping(current - 1, tried, nums)
    }

    fun jump(nums: IntArray): Int {
        return doJumping(nums.size - 2, IntArray(nums.size) { 0 }, nums)
    }
}