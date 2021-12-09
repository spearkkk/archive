package algorithm

class InterleavingString {
    private val holder: MutableSet<String> = mutableSetOf()

    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        // 빠지는 케이스
        if (s1 + s2 == s3 || s2 + s1 == s3) {
            return true
        }

        // 엣지 케이스
        if (s3.isBlank()) {
            holder.add(s1 + s2)
            holder.add(s2 + s1)
            return false
        }

        // 이미 처리한 케이스
        if (holder.contains(s1 + s2) || holder.contains(s2 + s1)) {
            return false
        }

        val first: Char = s3.first()
        val last: Char = s3.last()
        val left: String = s3.slice(1 until s3.length - 1)

        // s1, s1
        val s1s1 = if (s1.length >= 2 && s1.startsWith(first) && s1.endsWith(last)) isInterleave(s1.slice(1 until s1.length - 1), s2, left) else false

        // s2, s2
        val s2s2 = if (s2.length >= 2 && s2.startsWith(first) && s2.endsWith(last)) isInterleave(s1, s2.slice(1 until s2.length - 1), left) else false

        // s1, s2
        val s1s2 = if (s1.isNotBlank() && s2.isNotBlank() && s1.startsWith(first) && s2.endsWith(last)) isInterleave(s1.slice(1 until s1.length), s2.slice(0 until s2.length - 1), left) else false

        // s2, s1
        val s2s1 = if (s1.isNotBlank() && s2.isNotBlank() && s2.startsWith(first) && s1.endsWith(last)) isInterleave(s1.slice(0 until s1.length - 1), s2.slice(1 until s2.length), left) else false


        // 처리 결과가 실패면 기억하기
        val tmp = s1s1 || s2s2 || s1s2 || s2s1
        if (!tmp) {
            holder.add(s1 + s2)
            holder.add(s2 + s1)
        }
        return tmp
    }
}