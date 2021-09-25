package algorithm

class ReverseString {
    fun reverseString(s: CharArray): Unit {
        String(s).reversed().toCharArray().copyInto(s)
    }
}