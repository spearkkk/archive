package algorithm

class DecodeWays {
    private val decodes = (1 .. 26).map { it.toString() }.toSet()
    private val mem = hashMapOf<String, Int>()

    private fun canBe(s: String): Boolean {
        return decodes.contains(s)
    }

    private fun dig(s: String): Int {
        if (mem.contains(s)) {
            return mem.getOrDefault(s, 0)
        }

        if (s.isBlank()) {
            return 1
        }

        if (s.length == 1) {
            if (canBe(s)) {
                return 1
            }
            return 0
        }

        var tmp = 0
        if (canBe(s.slice(0 until 1))) {
            tmp += dig(s.slice(1 until s.length))
        }
        if (canBe(s.slice(0 until 2))) {
            tmp += dig(s.slice(2 until s.length))
        }
        mem[s] = tmp
        return tmp
    }

    fun numDecodings(s: String): Int {

        return dig(s)
    }
}