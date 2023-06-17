package leetcode.medium

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
fun main() {
    println(addTwoNumbers(ListNode(2), ListNode(3))?.next)
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var list1 = l1
    var list2 = l2
    val head = ListNode(0)
    var result: ListNode? = head
    var carry = 0
    while (list1 != null || list2 != null || carry > 0) {
        val x1 = list1?.`val` ?: 0
        val x2 = list2?.`val` ?: 0
        val sum = (x1 + x2 + carry) % 10
        carry = (x1 + x2 + carry) / 10
        result?.next = ListNode(sum)
        result = result?.next
        if (list1 != null) list1 = list1.next
        if (list2 != null) list2 = list2.next
    }
    return head.next
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}




