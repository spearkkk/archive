package algorithm

class ReverseVowelsOfAString {
    private fun isVowel(c: Char): Boolean {
        return charArrayOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').contains(c)
    }
    fun reverseVowels(s: String): String {
        val holder = s.toMutableList()

        val left = mutableListOf<Char>()
        val right = mutableListOf<Char>()

        for (i in 0 until s.length / 2) {
            if (isVowel(s[i])) {
                left.add(s[i])
            }
            if (isVowel(s[s.length - (1 + i)])) {
                right.add(s[s.length - (1 + i)])
            }
        }
        if (s.length % 2 == 1) {
            if (isVowel(s[s.length / 2])) {
                left.add(s[s.length / 2])
            }
        }

        for (i in holder.indices) {
            if (isVowel(holder[i])) {
                if (right.isNotEmpty()) {
                    holder[i] = right.removeFirst()
                } else if(left.isNotEmpty()) {
                    holder[i] = left.removeLast()
                }
            }
        }

        return String(holder.toCharArray())
    }
}