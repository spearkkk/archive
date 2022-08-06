package algorithm

/// https://leetcode.com/problems/generate-parentheses/
class GenerateParentheses {

    private fun dig(cur: String, openedCount: Int, closedCount: Int, n: Int, holder: MutableList<String>) {
        /// 괄호를 다 사용했기 때문에 holder 에 저장하고 리턴
        if (closedCount == n) {
            holder.add(cur)
            return
        }

        /// 괄호가 열려있으면 닫을 수 있기 때문에 닫는다
        if (openedCount > closedCount) {
            dig("$cur)", openedCount, closedCount + 1, n, holder)
        }
        /// 괄호가 n 보다 작게 열려있으면 더 열 수 있기 때문에 연다
        if (openedCount < n) {
            dig ("$cur(", openedCount + 1, closedCount, n, holder)
        }
    }

    fun generateParenthesis(n: Int): List<String> {
        val holder = mutableListOf<String>()
        dig("", 0, 0, n, holder);

        return holder.toList()
    }
}
