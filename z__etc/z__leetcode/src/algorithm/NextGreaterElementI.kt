package algorithm

/// https://leetcode.com/problems/next-greater-element-i/
class NextGreaterElementI {

    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val holder = IntArray(10000 + 1) { -1 }
        for (i in 0 until nums2.size - 1) {
            val cur = nums2[i]
            for (j in i + 1 until nums2.size) {
                if (cur < nums2[j]) {
                    holder[cur] = nums2[j]
                    break
                }
            }
        }

        return nums1.map { holder[it] }.toIntArray()
    }
}
