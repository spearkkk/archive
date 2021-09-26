package algorithm

class BinaryTreeLevelOrderTraversalII {
    private fun probe(map: MutableMap<Int, List<Int>>, level: Int, nodes: MutableList<TreeNode?>) {
        val holder: MutableList<Int> = mutableListOf()
        val children: MutableList<TreeNode?> = mutableListOf()

        for (node in nodes) {
            if (node != null) {
                holder.add(node.`val`)
                children.add(node.left)
                children.add(node.right)
            }
        }

        if (holder.size == 0) {
            return
        }

        map[level] = holder

        return probe(map, level + 1, children)
    }

    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val map: MutableMap<Int, List<Int>> = mutableMapOf()

        probe(map, 0, mutableListOf(root))


        val holder: MutableList<List<Int>> = mutableListOf()
        for (level in map.keys.reversed()) {
            holder.add(map[level]!!)
        }
        return holder

//        return map.entries.stream().sorted(Comparator.comparingInt { entry -> entry.key })
//                .map { entry -> entry.value.toList() }
//                .collect(Collectors.toList())
    }
}