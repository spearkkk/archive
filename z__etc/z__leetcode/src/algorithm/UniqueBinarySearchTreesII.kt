package algorithm

/// https://leetcode.com/problems/unique-binary-search-trees-ii/
class UniqueBinarySearchTreesII {

    private fun dig(from: Int, to: Int): List<TreeNode?> {
        /// 반드시 null을 가진 노드를 반환한다.
        if (from > to) {
            return arrayListOf(null)
        }

        val holder = mutableListOf<TreeNode>()
        for (i in from .. to) {
            val leftNodes = dig(from, i - 1)
            val rightNodes = dig(i + 1, to)

            for (leftNode in leftNodes) {
                for (rightNode in rightNodes) {
                    val parentNode = TreeNode(i)

                    parentNode.left = leftNode
                    parentNode.right = rightNode

                    holder.add(parentNode)
                }
            }
        }
        return holder
    }

    fun generateTrees(n: Int): List<TreeNode?> {
        return dig(1, n)
    }
}
