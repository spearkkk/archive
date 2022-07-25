package algorithm

/// https://leetcode.com/problems/sort-integers-by-the-power-value/
class SortIntegersByThePowerValue {

    private fun doLogic(n: Int): Int {
        if (n % 2 == 0) {
            return n / 2
        }
        return n * 3 + 1
    }

    fun getKth(lo: Int, hi: Int, k: Int): Int {
        val holder = IntArray(10001) { 0 }

        /// hi 범위까지 카운트를 구한다.
        for (i in 2 .. hi) {
            if (holder[i] == 0) {
                var tmp = i
                var cnt = 0

                while (tmp != 1) {
                    tmp = doLogic(tmp)
                    cnt += 1
                }

                holder[i] = cnt
            }
        }

        /// lo, hi 구간을 따로 떼어내어 데이터를 가지고 있는다.
        val array = ArrayList<Pair<Int, Int>>(hi - lo + 1)
        for (index in lo .. hi) {
            val tmp = Pair(holder[index], index)
            array.add(tmp)

        }

        /// 카운트 기준으로 정렬한 후, 원하는 값을 반환한다.
        return array.sortedBy { it.first } [k - 1].second
    }

}
