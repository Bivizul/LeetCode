package leetcode.easy

/**Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.**/

fun main() {
    val strs = arrayOf("flower", "flowht", "flight")
    println("longestCommonPrefix : ${longestCommonPrefix(strs)}")
    println("longestCommonPrefix2 : ${longestCommonPrefix2(strs)}")
    println("longestCommonPrefix3 : ${longestCommonPrefix3(strs)}") //  best
    println("longestCommonPrefix4 : ${longestCommonPrefix4(strs)}")
}

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    var commonPrefix = strs[0]
    for (i in 1 until strs.size) {
        while (strs[i].indexOf(commonPrefix) != 0) {
            commonPrefix = commonPrefix.substring(0, commonPrefix.length - 1)
            if (commonPrefix.isEmpty()) return ""
        }
    }
    return commonPrefix
}

fun longestCommonPrefix2(strs: Array<String>): String {
    var commonPrefix = ""
    if (strs.isEmpty()) return commonPrefix
    var list = strs.toList()
    var char = list.first().first()
    while (list.all { it.first() == char }) {
        commonPrefix += char
        list = list.map { it.drop(1) }
        if (list.any { it.isEmpty() }) return commonPrefix
        char = list.first().first()
    }
    return commonPrefix
}

//  best
fun longestCommonPrefix3(strs: Array<String>): String {
    var result = strs[0]
    for (i in 1 until strs.size) {
        val commonPrefix = getCommonPrefix3(result, strs[i])
        if (commonPrefix.isEmpty()) return ""
        result = commonPrefix
    }
    return result
}

fun getCommonPrefix3(str1: String, str2: String): String {
    val stringBuilder = StringBuilder()
    val size = Math.min(str1.length, str2.length)
    for (i in 0 until size) {
        if (str1[i] == str2[i]) stringBuilder.append(str1[i])
        else break
    }
    return stringBuilder.toString()
}

fun longestCommonPrefix4(strs: Array<String>): String {
    var result = strs[0]
    for (i in 1 until strs.size) {
        val commonPrefix = getCommonPrefix4(result, strs[i])
        if (commonPrefix.isEmpty()) return ""
        result = commonPrefix
    }
    return result
}

fun getCommonPrefix4(str1: String, str2: String): String {
    var stringNew = ""
    val size = Math.min(str1.length, str2.length)
    println(size)
    for (i in 0 until size) {
        if (str1[i] == str2[i]) {
            stringNew += (str1[i])
        } else {
            break
        }
    }
    return stringNew
}
