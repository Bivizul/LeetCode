package leetcode.easy

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 *
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do
 * the following things:
 *
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
 * The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * Custom Judge:
 *
 * The judge will test your solution with the following code:
 */
fun main() {
    println(removeElement(intArrayOf(3,2,2,3),3))
    println(removeElement(intArrayOf(0,1,2,2,3,0,4,2),2))
    println(removeElement2(intArrayOf(0,1,2,2,3,0,4,2),2))
}

fun removeElement(nums: IntArray, num: Int): Int {
    return nums.toMutableList().apply {
        removeAll{ it == num }
    }.size
}

fun removeElement2(nums: IntArray, num: Int): Int {
    var counter = 0
    nums.forEach { if (it != num) nums[counter++] = it }

    return counter
}