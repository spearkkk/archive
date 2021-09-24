package algorithm

/**
 * 1. left 와 right 를 비교한 후 작은 값을 현재 노드의 next 로 할당.
 * 2. 이후 반복.
 * 3. left 가 null 이면 right 전체를 할당.
 * 4. right 가 null 이면 left 전체를 할당.
 * 5. left, right 둘 다 null 이 현재 노드 반환.
 */
class MergeTwoSortedLists {

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val head = ListNode(-9999)

        var left = l1
        var right = l2
        var cur = head

        do {
            if (left == null || right == null) {
                if (right == null) {
                    cur.next = left
                } else {
                    cur.next = right
                }
                break
            }

            if (left.`val` > right.`val`) {
                cur.next = right
                cur = cur.next!!

                right = right.next
            } else {
                cur.next = left
                cur = cur.next!!

                left = left.next
            }
        } while (true)

        return head.next
    }
}