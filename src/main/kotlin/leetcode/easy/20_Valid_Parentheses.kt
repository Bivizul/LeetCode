package leetcode.easy

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
fun main() {
    val a = "()[]{}"
    val b = "({[]}"
    println("a " + isValid(s = a))
    println("b " + isValid(s = b))
}

// Variant 1
//fun isValid(s: String): Boolean {
//    var newS = ""
//    s.forEach { char ->
//        if (char == s.first()) {
//            newS += char
//            return@forEach
//        }
//        newS += when(newS.last()){
//            '(' -> if (char != ')') return false else char
//            '{' -> if (char != '}') return false else char
//            '[' -> if (char != ']') return false else char
//            else -> char
//        }
//    }
//    return true
//}

// Variant 2
fun isValid(s: String): Boolean {
    if (s == "") { return true }
    val cleared = s.replace("()", "").replace("{}", "").replace("[]", "")
    if (cleared == s) { return false }
    return isValid(cleared)
}

// Variant 3
//fun isValid(s: String): Boolean {
//    val stack = ArrayDeque<Char>()
//    s.forEach {
//        when(it) {
//            '(', '[', '{' -> stack.add(it)
//            ')' -> if (stack.contains('(').not()) return false
//            '}' -> if (stack.contains('{').not()) return false
//            ']' -> if (stack.contains('[').not()) return false
//        }
//    }
//    return stack.isEmpty()
//}