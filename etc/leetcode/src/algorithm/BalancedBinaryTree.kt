package algorithm

/**
 * ref.: https://youtu.be/-m154rqFQng
 */
class BalancedBinaryTree {
    private fun checkHeight(root: TreeNode?): Int {
        if (root == null) {
            return -1
        }

        val leftHeight: Int = checkHeight(root.left)
        if (leftHeight == Int.MIN_VALUE) {
            return leftHeight
        }
        val rightHeight: Int = checkHeight(root.right)
        if (rightHeight == Int.MIN_VALUE) {
            return rightHeight
        }

        val diff = leftHeight - rightHeight
        if (Math.abs(diff) > 1) {
            return Int.MIN_VALUE
        }
        return Math.max(leftHeight, rightHeight) + 1
    }

    fun isBalanced(root: TreeNode?): Boolean {
        return checkHeight(root) == Int.MIN_VALUE
    }
}