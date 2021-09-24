package algorithm

class LongestPalindrome {
    fun longestPalindrome(s: String): Int {
        val holder = IntArray(58) { 0 }

        for (cur in s) {
            holder[cur - 'A'] += 1
        }

        var result = 0
        if (holder.find { v -> v % 2 == 1 } != null) {
            result += 1
        }

        result += holder.filter { v -> v > 1 }.map { v -> (v / 2) * 2 }.sum()

        return result
    }
}