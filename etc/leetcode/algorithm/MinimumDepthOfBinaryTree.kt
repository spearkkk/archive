package algorithm

/**
 * 두개의 자식 중 한 자식이 null 일 때, null 인 자식이 아닌 노드의 깊이를 구해야한다.
 */
class MinimumDepthOfBinaryTree {
    private fun getHeight(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val leftHeight: Int = getHeight(root.left)
        val rightHeight: Int = getHeight(root.right)
        if (leftHeight == 0 && rightHeight == 0) {
            return 1
        }
        if (rightHeight == 0) {
            return leftHeight + 1
        }
        if (leftHeight == 0) {
            return rightHeight + 1
        }
        return leftHeight.coerceAtMost(rightHeight) + 1
    }

    fun minDepth(root: TreeNode?): Int {
        return getHeight(root)
    }
}