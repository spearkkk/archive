package algorithm

class SummaryRanges {
    private fun convert(min: Int, max: Int): String {
        if (min == max) {
            return min.toString()
        }
        return "$min->$max"
    }
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) {
            return listOf()
        }

        var currentIndex = 0

        val holder = mutableListOf<String>()
        do {
            var count = 0
            while (true) {
                if (currentIndex + count + 1 < nums.size && nums[currentIndex + count + 1].toLong() - nums[currentIndex + count] <= 1L) {
                    count += 1
                    continue
                }
                break
            }
            holder.add(convert(nums[currentIndex], nums[currentIndex + count]))
            currentIndex += count + 1

        } while (currentIndex < nums.size)

        return holder
    }
}