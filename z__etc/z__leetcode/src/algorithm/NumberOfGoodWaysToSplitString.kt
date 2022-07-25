package algorithm

/// https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
class NumberOfGoodWaysToSplitString {

    /**
     * 처음 답, 타임 초과로 실패
     * 문제에 대한 답 그대로 차례대로 부분 문자열을 앞/뒤로 만든 후, 고유한 문자가 몇개인지 검색하는 방법이다.
     * Set으로 구현하면 고유한 값을 갖고 있고 빠를줄 알았다.
     * 그런데 각 문자열에서 toSet()하는 것이 문자열이 클수록 오래 걸리는 듯하다.
     *
     * 그러면 문자열 정보를 처음에 다 들고 있고, 문자가 몇 개 있는지 알면 어떨까?
     */
//    fun numSplits(s: String): Int {
//        var sum = 0
//
//        for (i in 0 until s.length - 1) {
//            sum += if (s.substring(0 .. i).toSet() == s.substring(i + 1).toSet()) 1 else 0
//        }
//
//        return sum
//    }

    /**
     * 문자열의 고유한 문자를 초기화 해놓는다.
     * 왼쪽은 아직 부분 문자열이 없기 때문에 0
     * 오른쪽은 처음에는 전체 문자열이기 때문에 각 문자마다의 나오는 수가 배열에 들어 있음
     *
     * 문자를 하나씩 오른쪽에서 왼쪽으로 옮겨서 부분 문자열을 만드는 것처럼 생각해보자.
     * 그러면 옮겨가는 문자가 하나씩 가면서 그 수도 줄어들 것이다.
     * 하나씩 옮겨갈때마다 고유의 문자의 수가 같은지 확인한다.
     *
     * 배열의 값이 0인것은 그 문자가 문자열에 존재하지 않는다는 것을 뜻한다.
     * 즉, 0인 개수가 같다면, 고유한 문자의 개수도 같다.
     */
    fun numSplits(s: String): Int {
        val leftHolder = IntArray(26) { 0 }
        val rightHolder = IntArray(26) { 0 }

        for (i in s) {
            val index = i.code - 97

            rightHolder[index] += 1
        }

        var sum = 0
        for (i in s) {
            val index = i.code - 97

            leftHolder[index] += 1
            rightHolder[index] -= 1

            sum += if (leftHolder.count { it == 0 } == rightHolder.count { it == 0}) 1 else 0
        }


        return sum
    }

}
