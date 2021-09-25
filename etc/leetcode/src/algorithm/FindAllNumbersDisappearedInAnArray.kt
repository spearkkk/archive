package algorithm

class FindAllNumbersDisappearedInAnArray {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val holder = mutableListOf<Int>()

        for (i in 1 .. nums.size) {
            if (!nums.contains(i)) {
                holder.add(i)
            }
        }
        return holder
    }
}