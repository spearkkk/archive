package algorithm

/// https://leetcode.com/problems/partition-array-for-maximum-sum/
class PartitionArrayForMaximumSum {

    /// 메모제이션을 위해 만든 객체, 각 인덱스에 해당하는 최댓값을 가지고 있다.
    private val holder: MutableMap<Int, Int> = mutableMapOf()

    private fun dig(arr: IntArray, k: Int, cur: Int): Int {
        /// 재귀 빠지는 조건
        if (cur >= arr.size) {
            holder[cur] = 0
            return 0
        }

        /// 메모제이션에 값이 있으면 그 값을 사용.
        if (holder[cur] != null) {
            return holder[cur]!!
        }

        /// k 보다 작은 수의 배열이 남았다면 그 자체로 서브 배열이어야 함.
        if (cur + k >= arr.size) {
            var cnt = 0
            var max = -1
            for (i in cur until arr.size) {
                cnt += 1
                if (max < arr[i]) {
                    max = arr[i]
                }
            }

            holder[cur] = cnt * max
            return cnt * max
        }

        /// 서브배열을 안 만들고 다음 배열부터 만드는 경우
        var candi = arr[cur] + dig(arr, k, cur + 1)

        /**
         * 서브배열을 1부터 k크기까지 만든다.
         * 만들 때마다 큰 값이 나오면 갱신한다.
         * 마지막에 candi에 남은 값이 cur 인덱스의 최댓값이다.
         */
        for (i in 1 .. k) {
            var max = -1
            for (j in cur until cur + i) {
                if (max < arr[j]) {
                    max = arr[j]
                }
            }
            val tmp = max * i + dig(arr, k, cur + i)
            if (candi < tmp) {
                candi = tmp
            }
        }

        holder[cur] = candi
        return candi
    }

    fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
        return dig(arr, k, 0)
    }
}
