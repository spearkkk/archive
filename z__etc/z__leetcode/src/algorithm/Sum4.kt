package algorithm

class Sum4 {
    private fun seek(nums: IntArray, target: Int, base: Int): ArrayList<List<Int>> {
        // nums: sorted array

        var left = 0 + base + 1
        var right = nums.size - 1

        val result = ArrayList<List<Int>>()

        while (right - left > 1) {
            var center = left + 1

            while (center < right) {
                val tmp = nums[left] + nums[center] + nums[right]

                if (tmp == target) {
                    result.add(listOf(nums[base], nums[left], nums[center], nums[right]))
                    center += 1
                    right -= 1
                    continue
                }

                if (target > tmp) {
                    center += 1

                } else {
                    right -= 1
                }
            }
            left += 1
            right = nums.size - 1
        }
        return result
    }

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()

        val result = hashSetOf<List<Int>>()

        for (i in 0 .. nums.size - 2) {
            val tmp = seek(nums, target - nums[i], i)
            if (tmp.isNotEmpty()) {
                result.addAll(tmp)
            }
        }
        return result.toList()
    }
}