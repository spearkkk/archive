package algorithm

/**
 * ref.: https://jihyun22.github.io/leetcode/leetcode-08-16/
 */
class BestTimeToBuyAndSellStockIII {
    fun maxProfit(prices: IntArray): Int {
        var forward = IntArray(prices.size) { 0 }
        var backward = IntArray(prices.size) { 0 }

        var forwardMin = prices[0]
        var forwardMaxProfit = 0

        for (i in 1 until prices.size) {
            if (forwardMin > prices[i]) {
                forwardMin = prices[i]
                forward[i] = forwardMaxProfit
                continue
            }
            if (prices[i] - forwardMin > forwardMaxProfit) {
                forwardMaxProfit = prices[i] - forwardMin
            }
            forward[i] = forwardMaxProfit
        }

        var backwardMax = prices[prices.size - 1]

        for (i in (prices.indices).reversed()) {
            if (backwardMax < prices[i]) {
                backwardMax = prices[i]
                backward[i] = 0
                continue
            }
            backward[i] = backwardMax - prices[i]
        }

        var max = Int.MIN_VALUE
        for (i in prices.indices) {
            if (max < forward[i] + backward[i]) {
                max = forward[i] + backward[i]
            }
        }

        return max
    }
}