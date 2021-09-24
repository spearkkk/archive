package algorithm

class RemoveDuplicatesFromSortedList {
    private fun probe(currentHead: ListNode?) {
        if (currentHead == null) {
            return
        }

        val currentValue = currentHead.`val`
        var nextOne = currentHead.next
        while (nextOne != null && nextOne.`val` == currentValue) {
            nextOne = nextOne.next
        }
        currentHead.next = nextOne
        probe(nextOne)
    }
    fun deleteDuplicates(head: ListNode?): ListNode? {
        probe(head)
        return head
    }
}