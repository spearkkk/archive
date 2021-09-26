package algorithm

class RepeatedSubstringPattern {
    fun repeatedSubstringPattern(s: String): Boolean {
        var cur = 1

        while (s.length >= cur * 2) {
            val pattern = s.substring(0, cur)

            var start = cur

            while (start + cur <= s.length) {
                if (pattern != s.substring(start, start + cur)) {
                    cur += 1
                    break
                }
                start += cur
            }

            if (start == s.length) {
                return true
            }

            if (start + cur > s.length) {
                break
            }
        }
        return false
    }
}