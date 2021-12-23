package algorithm

class LongestIncreasingSubsequence {
    // recursive but time exceed
    private fun dig(currentMax: Int, currentPosition: Int, nums: IntArray): Int {
        if (currentPosition >= nums.size) {
            return 0
        }

        var tmp = 0
        if (currentMax < nums[currentPosition]) {
            tmp = dig(nums[currentPosition], currentPosition + 1, nums) + 1
        }
        val tmp2 = dig(currentMax, currentPosition + 1, nums)

        return if (tmp < tmp2) {
            tmp2
        } else {
            tmp
        }
    }

    fun lengthOfLIS(nums: IntArray): Int {
//        return dig(-10000 - 1, 0, nums)

        // nums를 역방향(역순)으로 진행하면서 해당 값을 선택했을 때와 선택하지 않았을 때의 카운트를 저장한다.
        // key 값은 현재까지 만든 부분 집합에서 제일 값이 작은 숫자, value 값은 현재까지 만든 부분 집합의 원소 개수
        // holder에는 계속 값이 추가만 되지 사라지지 않는다. 선택하지 않았을 때의 미래에서 선택이 될 수 있어야하고 이 값이 부분 집합이 더 클 수 있다.
        val holder: MutableMap<Int, Int> = mutableMapOf()

        for (i in nums.indices.reversed()) {
            val cnt = (holder.filter { it.key > nums[i] }.maxByOrNull { it.value }?.value ?: 0) + 1
            holder[nums[i]] = cnt
        }

        return holder.maxByOrNull { it.value }?.value ?: 1
    }
}