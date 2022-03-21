// TODO needs to improve a lot. Bad solution.
class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val ordered = nums.sorted()

        var lastNumber = 0
        for (it in ordered) {
            if (it <= 0) {
                continue
            }

            if (it != lastNumber && it != lastNumber + 1) {
                return lastNumber + 1
            }

            lastNumber = it
        }

        return lastNumber + 1
    }
}

fun test(array: IntArray, expectedOutput: Int) {
    val smallerPositive = Solution().firstMissingPositive(array)
    println(smallerPositive == expectedOutput)
}

test(intArrayOf(1, 2, 0), 3)
test(intArrayOf(1, 2, 3, 4), 5)
test(intArrayOf(1, 10, 20, 30, 40), 2)
test(intArrayOf(1, 2, 3, 4, 6), 5)
test(intArrayOf(1, 2, 6, 4, 3), 5)
test(intArrayOf(-1, -2, -3), 1)
test(intArrayOf(7, 8, 9, 10), 1)
test(intArrayOf(0, 8, 9, 10), 1)
