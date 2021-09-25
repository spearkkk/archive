package algorithm

class PascalsTriangleII {
    private fun generate(numRows: Int): List<List<Int>> {
        if (numRows == 0) {
            return listOf()
        }

        val holder: MutableList<List<Int>> = mutableListOf(listOf(1))

        for (i in 2 .. numRows) {
            val tmp: MutableList<Int> = mutableListOf(holder[i - 1 - 1][0])
            for (j in 1 until i - 1) {
                tmp.add(holder[i - 1 - 1][j - 1] + holder[i - 1 - 1][j])
            }
            tmp.add(holder[i - 1 - 1][i - 2])
            holder.add(tmp)
        }
        return holder
    }

    fun getRow(rowIndex: Int): List<Int> {
        return generate(rowIndex + 1).get(rowIndex)
    }
}