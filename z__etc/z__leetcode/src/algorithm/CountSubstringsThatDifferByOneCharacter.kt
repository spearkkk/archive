package algorithm

/// https://leetcode.com/problems/count-substrings-that-differ-by-one-character/
class CountSubstringsThatDifferByOneCharacter {
    /**
     * 주어진 두 문자열이 단 하나의 문자만 다를 경우 true, 아닐 경우 false
     * 문자열의 길이는 같다
     */
    private fun couldBe(s: String, t: String): Boolean {
        if (s.length == 1 && s != t) {
            return true
        }

        var cnt = 0

        for (i in s.indices) {
            if (cnt > 1) {
                return false
            }

            if (s[i] != t[i]) {
                cnt += 1
            }
        }

        return cnt == 1
    }

    /**
     * 주어진 문자열의 모든 하위 문자열을 반환하는데, 하위 문자열의 길이를 키로 가진다.
     */
    private fun getAllSubStrings(str: String): Map<Int, List<String>> {
        val holder = mutableMapOf<Int, List<String>>()

        for (i in 1 .. str.length) {
            val subStrings: ArrayList<String> = arrayListOf()

            for (j in 0 .. str.length - i) {
                val candi = str.slice(j until j + i)

                subStrings.add(candi)
            }

            holder.put(i, subStrings)
        }

        return holder
    }

    fun countSubstrings(s: String, t: String): Int {

        val sLevelToSubStrings = getAllSubStrings(s)
        val tLevelToSubStrings = getAllSubStrings(t)

        var sum = 0
        /// s문자열만 확인하기 때문에, s 하위 문자열만 반복
        for (level in sLevelToSubStrings.keys) {
            val sSubStrings = sLevelToSubStrings.getOrDefault(level, listOf())
            val tSubStrings = tLevelToSubStrings.getOrDefault(level, listOf())

            for (tmpS in sSubStrings) {
                for (tmpT in tSubStrings) {
                    if (couldBe(tmpS, tmpT)) {
                        sum += 1
                    }
                }
            }

        }

        return sum
    }
}
