package algorithm

class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        val ss = s.trim()
        return ss.substring(ss.lastIndexOf(" ") + 1).length
    }
}