package algorithm

class LongestPalindromicSubstring {
    private fun isPanlidrome(cur: String): Boolean {
        for (i in 0 until cur.length / 2) {
            if (cur[i] != cur[cur.length - i - 1]) {
                return false
            }
        }
        return true
    }

    fun longestPalindrome(s: String): String {
        if (isPanlidrome(s)) {
            return s
        }

        for (sz in (s.indices).reversed()) {
            var i = 0
            while (i + sz <= s.length) {
                if (isPanlidrome(s.slice(i until sz + i))) {
                    return s.slice(i until sz + i)
                }
                i += 1
            }
        }

        return s
    }
}