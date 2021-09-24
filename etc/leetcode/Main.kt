import algorithm.*

fun main() {

//    val node1st = ListNode(1)
//    val node2nd = ListNode(2)
//    val node3rd = ListNode(3)
//    val node4th = ListNode(3)
//    val node5th = ListNode(2)
//    val node6th = ListNode(1)

//    node1st.next = node2nd
//    node2nd.next = node3rd
//    node3rd.next = node4th
//    node4th.next = node5th
//    node5th.next = node6th

    val root = TreeNode(1)
    val rootLeft = TreeNode(2)
    val rootRight = TreeNode(3)

    root.left = rootLeft
    root.right = rootRight

    // rootLeft
    val rootLeftLeft = TreeNode(4)
    val rootLeftRight = TreeNode(5)
    rootLeft.left = rootLeftLeft
    rootLeft.right = rootLeftRight

    // rootRight
//    val rootRightLeft = TreeNode(4)
//    val rootRightRight = TreeNode(5)
//    rootRight.left = rootRightLeft
//    rootRight.right = rootRightRight

    // rootLeftRight
//    val rootLeftRightLeft = TreeNode(3)
//    val rootLeftRightRight = TreeNode(5)
//    rootLeftRight.left = rootLeftRightLeft
//    rootLeftRight.right = rootLeftRightRight

    println(NumberComplement().findComplement(2147483647))
}