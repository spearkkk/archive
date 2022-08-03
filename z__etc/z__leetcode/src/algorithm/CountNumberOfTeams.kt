package algorithm

/// https://leetcode.com/problems/count-number-of-teams/
class CountNumberOfTeams {

    fun numTeams(rating: IntArray): Int {
        var sum = 0

        /**
         * 맨 오른쪽과 맨 왼쪽은 조사하지 않아도 된다.
         * 가운데 있는 값들을 반복하여 자기 자신보다 작은 것은 왼쪽, 큰 것은 오른쪽에 있는지 확인한다.
         * 자기 자신을 포함하여 왼쪽에서 하나, 오른쪽에서 하나 고를 수 있는 경우의 수를 구한다.
         *
         * 오름차순과 같이 내림차순도 동일하게 한다.
         * 이를 더하면 답이다.
         */
        for (cur in 1 until rating.size - 1) {
            var leftSmall = 0
            var leftLarge = 0
            for (it in 0 until cur) {
                if (rating[it] < rating[cur]) {
                    leftSmall += 1
                }
                if (rating[it] > rating[cur]) {
                    leftLarge += 1
                }
            }

            var rightLarge = 0
            var rightSmall = 0

            for (it in cur + 1 until rating.size) {
                if (rating[cur] < rating[it]) {
                    rightLarge += 1
                }
                if (rating[cur] > rating[it]) {
                    rightSmall += 1
                }
            }
            /// leftSmall * rightLarge: 오름차순
            /// leftLarge * rightSmall: 내림차순
            sum += leftSmall * rightLarge + leftLarge * rightSmall
        }

        return sum
    }
}