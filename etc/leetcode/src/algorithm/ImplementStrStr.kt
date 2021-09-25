package algorithm

class ImplementStrStr {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) {
            return 0
        }
        return haystack.indexOf(needle)
    }
}