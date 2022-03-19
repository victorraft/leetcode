import kotlin.math.absoluteValue

class Solution {
    
    fun sortedSquaresEasy(nums: IntArray): IntArray =
        nums.map { it * it }
            .sorted()
            .toIntArray()

    fun sortedSquares(nums: IntArray): IntArray {
        var start = 0
        var end = nums.size - 1
        val result = IntArray(nums.size)

        for (i in nums.size - 1 downTo 0) {
            val startAbsValue = nums[start].absoluteValue
            val endAbsValue = nums[end].absoluteValue

            if (startAbsValue > endAbsValue) {
                result[i] = startAbsValue * startAbsValue
                start++
            } else {
                result[i] = endAbsValue * endAbsValue
                end--
            }
        }

        return result
    }
}

fun test(input: IntArray, expectedOutput: IntArray): Boolean {
    val output = Solution().sortedSquares(input)
    println(output.joinToString())
    println(expectedOutput.joinToString())
    return output.contentEquals(expectedOutput)
}

test(
    input = intArrayOf(-4, -1, 0, 3, 10),
    expectedOutput = intArrayOf(0, 1, 9, 16, 100)
)

test(
    input = intArrayOf(-7, -3, 2, 3, 11),
    expectedOutput = intArrayOf(4, 9, 9, 49, 121)
)
