package algorithm

/**
 * 0번째 인덱스는 무시하기 위해 크기를 301,
 * `nums`의 길이가 최대 300이기 때문에 이를 고려하여 +1, 따라서 302
 *
 * `i`의 값이 300 이상은 고려하지 않아도 된다.
 * 왜냐하면 300 이상이 숫자가 있다는 것은 300 이하의 숫자 중 하나가 이미 nums에 없다는 뜻이다.
 */
class FirstMissingPositive {
    fun firstMissingPositive(nums: IntArray): Int {
        val holder = BooleanArray(302) { false }
        holder[0] = true
        var minimumPositivePosition = 1

        for (i in nums) {
            if (i < 0 || i > 300) {
                continue
            }
            holder[i] = true
            if (i == minimumPositivePosition) {
                minimumPositivePosition = holder.indexOfFirst { value -> !value }
            }
        }
        return minimumPositivePosition
    }
}