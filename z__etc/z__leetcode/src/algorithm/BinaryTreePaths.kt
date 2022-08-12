package algorithm

/// https://leetcode.com/problems/binary-tree-paths/
class BinaryTreePaths {

    private fun dig(parent: TreeNode, path: String, result: MutableList<String>) {
        if (parent.left == null && parent.right == null) {
            result.add(path)
        }

        if (parent.left != null) {
            dig(parent.left!!, "$path->${parent.left!!.`val`}", result)
        }

        if (parent.right != null) {
            dig(parent.right!!, "$path->${parent.right!!.`val`}", result)
        }
    }

    fun binaryTreePaths(root: TreeNode?): List<String> {
        if (root == null) {
            return emptyList()
        }
        val result = mutableListOf<String>()
        dig(root, "${root.`val`}", result)
        return result
    }
}
