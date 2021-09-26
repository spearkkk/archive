package algorithm

class AssignCookies {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sortDescending()
        s.sortDescending()

        var footPrint = -1
        var sum = 0

        for (cur in s) {
            for (i in footPrint + 1 until g.size) {
                footPrint += 1
                if (cur >= g[i]) {
                    sum += 1
                    break
                }
            }
        }
        return sum
    }
}