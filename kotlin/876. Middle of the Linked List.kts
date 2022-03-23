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

class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        var lastNode = head
        var middleNode = head

        while (lastNode?.next != null) {
            middleNode = middleNode?.next
            lastNode = lastNode?.next?.next
        }

        return middleNode
    }
}
