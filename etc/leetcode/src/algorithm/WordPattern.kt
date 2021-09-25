package algorithm

class WordPattern {
    fun wordPattern(pattern: String, s: String): Boolean {
        val holder = HashMap<Char, String>()

        val splits = s.split(' ')

        if (pattern.length != splits.size) {
            return false
        }

        for (i in pattern.indices) {
            val currentPattern: Char = pattern[i]
            val currentSplit: String = splits[i].trim()

            if (holder.containsKey(currentPattern)) {
                if (holder[currentPattern]!! != currentSplit) {
                    return false
                }
                continue
            } else {
                if (holder.values.toSet().contains(currentSplit)) {
                    return false
                }
                holder[currentPattern] = currentSplit
            }
        }
        return true
    }
}