/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

// TODO can it be done better?
class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        var count = 0
        var lastNode = head
        var middleNode = head

        while (lastNode != null) {
            count++
            lastNode = lastNode.next
            if (count % 2 == 0) {
                middleNode = middleNode?.next
            }
        }

        return middleNode
    }
}

fun test(head: ListNode?) {
    val middleNode = Solution().middleNode(head)
    println(middleNode)
}
