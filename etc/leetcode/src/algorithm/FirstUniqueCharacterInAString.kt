package algorithm

class FirstUniqueCharacterInAString {
    fun firstUniqChar(s: String): Int {
        val holder = BooleanArray(s.length) { true }

        for (i in 1 until s.length) {
            for (j in 0 until i) {
                if (s[j] == s[i]) {
                    holder[j] = false
                    holder[i] = false
                    break
                }
            }
        }

        return holder.withIndex().find { indexedValue -> indexedValue.value }?.index ?: -1
    }
}