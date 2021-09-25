package algorithm

class ContainsDuplicateII {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        if (k == 0) {
            return false
        }

        val holder = hashSetOf<Int>()

        for (i in 0 .. k) {
            if (i < nums.size) {
                if (holder.contains(nums[i])) {
                    return true
                }
                holder.add(nums[i])
            }
        }

        for (i in 0 until nums.size - k - 1) {
            holder.remove(nums[i])
            if (holder.contains(nums[i + k + 1])) {
                return true
            }
            holder.add(nums[i + k + 1])
        }
        return false
    }
}