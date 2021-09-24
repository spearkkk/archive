package algorithm

/**
 * 1. Prefix를 제일 처음 문자로 만든다.
 * 2. 이후 데이터를 비교 후, common prefix를 만족하는 가장 긴 단어로 만든다.
 * 3. 새로 만들어진 prefix로 이후 데이터를 반복한다.
 */
class LongestCommonPrefix {
    private fun getPrefix(prefix: String, str: String): String {
        if (str.startsWith(prefix)) {
            return prefix
        }
        if (str.length < prefix.length && prefix.startsWith(str)) {
            return str
        }
        var tmp: String = prefix
        do {
            tmp = tmp.substring(0, tmp.length - 1)
            if (str.startsWith(tmp)) {
                return tmp
            }
        } while (tmp.isNotEmpty())
        return ""
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }

        var commonPrefix: String = strs[0]

        for (str in strs) {
            if (commonPrefix.isEmpty()) {
                return ""
            }

            commonPrefix = getPrefix(commonPrefix, str)
        }
        return commonPrefix
    }
}