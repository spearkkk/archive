package algorithm

class CountSortedVowelStrings {

    fun countVowelStrings(n: Int): Int {
        val holder = intArrayOf(1, 1, 1, 1, 1)

        for (i in 2 .. n) {
            val tmpHolder = IntArray(5)

            for (j in 0 until 5) {
                tmpHolder[j] = holder.slice(0 .. j).sum()
            }

            for (j in 0 until 5) {
                holder[j] = tmpHolder[j]
            }
        }

        return holder.sum()
    }
}
