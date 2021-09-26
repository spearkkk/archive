package algorithm

class ClimbStairs {
    fun climbStairs(n: Int): Int {
        val count: MutableList<Int> = MutableList(46) { 0 }
        count.add(1, 1)
        count.add(2, 2)

        for (i in 3 .. n) {
            count[i] = count[i - 2] + count[i - 1]
        }

        return count[n]
    }
}