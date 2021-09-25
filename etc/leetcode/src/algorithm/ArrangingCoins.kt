package algorithm

class ArrangingCoins {
    private fun minimum(cur: Long): Long {
        return cur * (cur + 1)
    }
    private fun maximum(cur: Long): Long {
        return (cur + 1) * (cur + 2)
    }

    fun arrangeCoins(n: Int): Int {

        var cur = 1
        while (true) {
            val tmp = n * 2L
            if (minimum(cur.toLong()) <= tmp
                    && tmp < maximum(cur.toLong())) {
                return cur
            }
            cur += 1
        }
    }
}