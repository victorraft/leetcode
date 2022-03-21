class Solution {
    fun isPalindromeEasy(x: Int): Boolean {
        val xString = x.toString()
        return xString == xString.reversed()
    }

    fun isPalindrome(x: Int): Boolean {
        when {
            x < 0 -> return false
            x < 10 -> return true
        }

        val digitList = breakNumberIntoDigitsList(x)
        return isDigitListPalindrome(digitList)
    }

    private fun breakNumberIntoDigitsList(num: Int): List<Int> {
        val digitList = mutableListOf<Int>()
        var remaining = num

        while (remaining > 0) {
            val lastDigit = remaining % 10
            remaining /= 10

            digitList.add(lastDigit)
        }

        return digitList
    }

    private fun isDigitListPalindrome(digitList: List<Int>): Boolean {
        var start = 0
        var end = digitList.lastIndex

        while (start < end) {
            val startDigit = digitList[start]
            val endDigit = digitList[end]

            if (startDigit == endDigit) {
                start++
                end--
            } else {
                return false
            }
        }

        return true
    }
}

fun test(input: Int, expectedOutput: Boolean): Boolean {
    val isPalindrome = Solution().isPalindrome(input)
    val success = isPalindrome == expectedOutput
    println("success: $success")
    return success
}

test(1234, expectedOutput = false)
test(1000021, expectedOutput = false)
test(-121, expectedOutput = false)
test(10, expectedOutput = false)

test(121, expectedOutput = true)
test(0, expectedOutput = true)
test(1221, expectedOutput = true)
test(12233221, expectedOutput = true)
test(1234554321, expectedOutput = true)
