class Solution {
    fun reverseString(s: CharArray): Unit {
        var start = 0
        var end = s.lastIndex

        while (start < end) {
            val temp = s[start]
            s[start] = s[end]
            s[end] = temp

            start++
            end--
        }
    }
}

fun test(s: CharArray, expectedArray: CharArray) {
    Solution().reverseString(s)
    println(s.contentEquals(expectedArray))
}

test(charArrayOf('h', 'e', 'l', 'l', 'o'), expectedArray = charArrayOf('o', 'l', 'l', 'e', 'h'))
test(charArrayOf('H', 'a', 'n', 'n', 'a', 'h'), expectedArray = charArrayOf('h', 'a', 'n', 'n', 'a', 'H'))