package algorithm

/// https://leetcode.com/problems/palindrome-partitioning/
/// https://leetcode.com/problems/palindrome-partitioning/discuss/182307/Java%3A-Backtracking-Template-General-Approach
class PalindromePartitioning {
    private fun isPalindrome(cur: String): Boolean {
        for (i in 0 .. cur.length / 2) {
            if (cur[i] != cur[cur.length - 1 - i]) {
                return false
            }
        }

        return true
    }

    private fun dig(cur: String, step: MutableList<String>, result: MutableList<List<String>>) {
        if (cur.isBlank()) {
            result.add(step.toList())
            return
        }

        for (i in 1 .. cur.length) {
            val subString = cur.slice(0 until i)

            if (isPalindrome(subString)) {
                step.add(subString)
                dig(cur.slice(i until cur.length), step, result)
                step.removeAt(step.size - 1)
            }
        }
    }

    fun partition(s: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        dig(s, mutableListOf(), result)
        return result.toList()
    }
}
