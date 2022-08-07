package algorithm

/// https://leetcode.com/problems/unique-binary-search-trees/
class UniqueBinarySearchTrees {
    /// size to count, range가 일정하면 생성되는 개수는 항상 같다.
    private val holder = mutableMapOf<Int, Int>()

    private fun dig(from: Int, to: Int): Int {
        if (from > to) {
            return 1
        }

        if (holder.containsKey(to - from)) {
            return holder[to - from]!!
        }

        var sum = 0
        for (i in from .. to) {
            val leftNodes = dig(from, i - 1)
            val rightNodes = dig(i + 1, to)

            sum += leftNodes * rightNodes
        }

        holder[to - from] = sum
        return sum
    }

    fun numTrees(n: Int): Int {
        return dig(1, n)
    }
}
