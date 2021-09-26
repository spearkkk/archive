package algorithm

class DeleteNodeInALinkedList {
    fun deleteNode(node: ListNode?) {
        var cur = node
        while (true) {
            cur!!.`val` = cur!!.next!!.`val`

            if (cur!!.next!!.next == null) {
                cur.next = null
                break
            }

            cur = cur.next
        }
    }
}