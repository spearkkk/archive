package algorithm

class AddDigits {

    fun addDigits(num: Int): Int {
        var tmp = num.toString().map { it -> Character.getNumericValue(it) }.sum()
        while (tmp / 10 != 0) {
            tmp = tmp.toString().map { it -> Character.getNumericValue(it) }.sum()
        }
        return tmp
    }
}