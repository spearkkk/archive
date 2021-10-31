package algorithm

class JumpGame {

    private fun isDone(cur: Int, nums: IntArray): Boolean {
        return cur + nums[cur] >= nums.size - 1
    }

    private fun trying(cur: Int, nums: IntArray, marked: IntArray): Boolean {
        if (marked[cur] == 1) {
            return false
        }

        if (isDone(cur, nums)) {
            return true
        }

        marked[cur] = 1

        for (i in 0 until nums[cur]) {
            if (trying(cur + i + 1, nums, marked)) {
                return true
            }
        }
        return false
    }

    fun canJump(nums: IntArray): Boolean {
        val marked = IntArray(nums.size) { 0 }

        return trying(0, nums, marked)
    }
}