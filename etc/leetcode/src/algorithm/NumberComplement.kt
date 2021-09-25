package algorithm

class NumberComplement {
    fun findComplement(num: Int): Int {

        var cap = 1L

        while (cap <= num) {
            cap = cap.shl(1)
        }
        return (cap - 1).toInt().xor(num)
    }
}