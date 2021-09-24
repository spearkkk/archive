package algorithm

class SameTree {
    private fun validate(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) {
            return true
        }

        if (left != null && right != null && left.`val` == right.`val`) {
            return validate(left.left, right.left) && validate(left.right, right.right)
        }

        return false
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return validate(p, q)
    }
}