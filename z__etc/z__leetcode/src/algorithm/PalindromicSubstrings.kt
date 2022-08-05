package algorithm

/// https://leetcode.com/problems/palindromic-substrings
class PalindromicSubstrings {
    private fun isPanlidrome(cur: String): Boolean {
        for (i in 0 until cur.length / 2) {
            if (cur[i] != cur[cur.length - i - 1]) {
                return false
            }
        }
        return true

    }

    fun countSubstrings(s: String): Int {
        // 길이가 1이면 무조건 palindrome
        var sum = s.length

        /**
         * 길이가 2부터 최대 s의 길이까지 sub string을 만들어서 검사한다.
         */
        for (i in 2 .. s.length) {
            for (j in 0 .. s.length - i) {
                if (isPanlidrome(s.slice(j until j + i))) {
                    sum += 1
                }
            }
        }
        return sum
    }
}
