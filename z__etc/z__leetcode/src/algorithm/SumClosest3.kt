package algorithm

import kotlin.math.abs

/**
 * 정렬한 후, 맨 앞을 고정 시킨 후 두개의 포인터가 앞, 뒤로 좁혀 온다.
 * 한번의 루프가 끝나면 맨 앞을 뒤로 이동 시킨다.
 */
class SumClosest3 {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()

        var left = 0
        var right = nums.size - 1

        var result = 999999

        while (right - left > 1) {
            var center = left + 1

            while (center < right) {
                val tmp = nums[left] + nums[center] + nums[right]

                if (abs(target - result) > abs(target - tmp)) {
                    result = tmp
                }

                if (target > tmp) {
                    center += 1

                } else if (target < tmp) {
                    right -= 1


                } else {
                    return target
                }
            }
            left += 1
            right = nums.size - 1
        }

        return result
    }
}