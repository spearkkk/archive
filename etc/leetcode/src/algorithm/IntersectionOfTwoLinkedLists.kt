package algorithm

class IntersectionOfTwoLinkedLists {
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        val holder = hashSetOf<ListNode>()

        var cur = headA
        while (cur != null) {
            holder.add(cur)
            cur = cur.next
        }

        cur = headB
        while (cur != null) {
            if (holder.contains(cur)) {
                return cur
            }
            cur = cur.next
        }
        return null
    }
}