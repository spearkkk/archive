package algorithm

class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        val holder = hashMapOf<Char, Int>()

        for (c in s) {
            var tmp = holder.getOrDefault(c, 0)
            tmp += 1
            holder[c] = tmp
        }

        for (c in t) {
            var tmp = holder.getOrDefault(c, 0)
            if (tmp == 0) {
                return false
            }
            tmp -= 1
            holder[c] = tmp
        }

        if (holder.values.find { tmp -> tmp != 0 } != null) {
            return false
        }
        return true
    }
}