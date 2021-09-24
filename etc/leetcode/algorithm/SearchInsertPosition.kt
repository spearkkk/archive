package algorithm

class SearchInsertPosition {
    private fun probe(left: IntArray, right: IntArray, target: Int): Int {
        if (left.isNotEmpty() && left.last() < target) {
            val tmp = right.size / 2
            return left.size + probe(right.slice(0 until tmp).toIntArray(),
                    right.slice(tmp until right.size).toIntArray(),
                    target)
        }
        if (right.isNotEmpty() && right.first() >= target) {
            val tmp = left.size / 2
            return probe(left.slice(0 until tmp).toIntArray(),
                    left.slice(tmp until left.size).toIntArray(), target)
        }
        return left.size + right.size
    }

    fun searchInsert(nums: IntArray, target: Int): Int {
        val tmp = nums.size / 2
        return probe(nums.slice(0 until tmp).toIntArray(), nums.slice(tmp until nums.size).toIntArray(), target)
    }
}