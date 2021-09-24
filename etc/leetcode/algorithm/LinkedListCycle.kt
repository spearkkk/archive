package algorithm

class LinkedListCycle {
    fun hasCycle(head: ListNode?): Boolean {
        val holder = HashSet<ListNode>()

        var cur = head
        while (cur != null) {
            if (holder.contains(cur)) {
                return true
            }
            holder.add(cur)
            cur = cur.next
        }
        return false
    }
}