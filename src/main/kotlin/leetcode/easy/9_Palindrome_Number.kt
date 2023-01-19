package leetcode.easy

/**
Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Constraints:

-231 <= x <= 231 - 1

Follow up: Could you solve it without converting the integer to a string?
 **/

fun main() {
    val x = 12121
    println("X = $x")
    println("Is palindrome : ${isPalindrome(x)}")
    println("Is palindrome2 : ${isPalindrome2(x)}")
}

fun isPalindrome(x: Int): Boolean {
    val xx = x.toString()
    var a = 0
    var b = xx.length - 1
    while (a <= xx.length && xx[a] == xx[b]) {
        if (a == xx.length - 1) {
            return true
        }
        a++
        b--
    }
    return false
}

fun isPalindrome2(x: Int): Boolean {
    if (x < 0) return false
    var a = x
    var b = 0
    while (a != 0) {
        b = b * 10 + (a % 10)
        a /= 10
    }
    return b == x
}
