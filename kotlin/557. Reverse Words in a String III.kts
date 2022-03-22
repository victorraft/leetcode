class Solution {
    fun reverseWords(s: String): String {
        return s.split(" ").joinToString(" ") { word -> word.reversed() }
    }
}

fun test(s: String, expectedString: String) {
    val result = Solution().reverseWords(s)
    println(result)
    println(result == expectedString)
}

test("Let's take LeetCode contest", expectedString = "s'teL ekat edoCteeL tsetnoc")
test("God Ding", expectedString = "doG gniD")