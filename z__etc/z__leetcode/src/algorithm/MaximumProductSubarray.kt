package algorithm

class MaximumProductSubarray {
    private var max = Int.MIN_VALUE

    // matrix 를 만드는데, 반쪽 행렬을 만든다.
    // 그러나 데이터를 다 저장할 필요가 없다. 왜냐하면 maximum 값만 비교하면 되니깐.
    // i가 행, j가 열이면 행마다의 maximum 값을 구한다고 생각하자.
    fun maxProduct(nums: IntArray): Int {
        for (i in nums.indices) {
            var tmp = 1
            for (j in i until nums.size) {

                if (i == j) {
                    if (max < nums[i]) {
                        max = nums[i]
                    }
                    tmp *= nums[i]
                    continue
                }

                tmp *= nums[j]

                if (max < tmp) {
                    max = tmp
                }
            }
        }
        return max
    }
}