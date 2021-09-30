package algorithm

/**
 * 정렬한 후, 맨 앞을 고정 시킨 후 두개의 포인터가 앞, 뒤로 좁혀 온다.
 * 한번의 루프가 끝나면 맨 앞을 뒤로 이동 시킨다.
 */
class Sum3 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()

        var left = 0
        var right = nums.size - 1

        val result = arrayListOf<List<Int>>()

        while (right - left > 1) {
            var center = left + 1

            while (center < right) {
                val tmp = nums[left] + nums[center] + nums[right]
                if (tmp == 0) {
                    result.add(listOf(nums[left], nums[center], nums[right]))
                    center += 1
                    right -= 1
                } else if (tmp < 0){
                    center += 1
                } else {
                    right -= 1
                }
            }
            left += 1
            right = nums.size - 1
        }

        return result.distinct()
    }
}