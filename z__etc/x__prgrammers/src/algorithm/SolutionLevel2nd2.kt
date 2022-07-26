import java.util.*

class SolutionLevel2nd2 {
    fun solution(citations: IntArray): Int {
        val n = citations.size

        for (h in (0 .. n).reversed()) {

            val cnt = citations.count { it >= h }

            if (h > cnt) {
                continue
            }

            if (n - cnt >= h) {
                continue
            }

            return h
        }

        return 0
    }
}
