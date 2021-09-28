package algorithm

class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1

        var result = 0

        while (left < right) {
            if (height[left] < height[right]) {
                val tmp = height[left] * (right - left)
                if (result < tmp) {
                    result = tmp
                }
                left += 1
            } else {
                val tmp = height[right] * (right - left)
                if (result < tmp) {
                    result = tmp
                }
                right -= 1
            }
        }

        return result
    }
}