package algorithm

/// https://leetcode.com/problems/excel-sheet-column-number/
class ExcelSheetColumnNumber {

    fun titleToNumber(columnTitle: String): Int {
        var result = 0
        for (i in columnTitle.indices) {
            var tmp = 1
            for (j in 1 .. i) {
                tmp *= 26
            }
            result += tmp * (columnTitle[columnTitle.length - i - 1].code - 64)
        }

        return result
    }
}
