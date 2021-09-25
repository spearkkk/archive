package algorithm

class BestTimeToBuyAndSellStockII {
    fun maxProfit(prices: IntArray): Int {
        var i = 0
        var valley = prices[0]
        var peak = prices[0]
        var maxprofit = 0
        while (i < prices.size - 1) {
            /// 제일 낮은 곳을 찾는다.
            while (i < prices.size - 1 && prices[i] >= prices[i + 1]) {
                i++
            }
            valley = prices[i]

            /// 낮은 곳 이후의 조금이라도 높은 곳을 찾는다.
            while (i < prices.size - 1 && prices[i] <= prices[i + 1]) {
                i++
            }
            peak = prices[i]

            /// 이득을 넣어놓고 이후 지점부터 반복한다.
            maxprofit += peak - valley
        }
        return maxprofit
    }
}