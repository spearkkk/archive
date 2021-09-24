package algorithm

/**
 * 현재 위치의 값이 주어진 값인 `val`과 같다면 유요한 위치(limit)의 마지막 값으로 변경한다. 단, 현재 위치의 index 값은 변하지 않음.
 * 그리고 limit 를 감소시킨다.
 *
 * `val`과 다르다면 현재 위치의 index 를 증가 시킨다.
 */
class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var cur = 0
        var limit = nums.size

        while (cur < limit) {
            if (nums[cur] == `val`) {
                nums[cur] = nums[limit - 1]
                nums[limit - 1] = -1
                limit -= 1
            } else {
                cur += 1
            }
        }

        return limit
    }
}