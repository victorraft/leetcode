class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var start = 0
        var end = numbers.lastIndex

        if (numbers.size > 2) {
            while (start < end) {
                val sum = numbers[start] + numbers[end]
                if (sum == target) {
                    break
                } else if (sum < target) {
                    start++
                } else if (sum > target) {
                    end--
                }
            }
        }

        return intArrayOf(start + 1, end + 1)
    }
}

fun test(numbers: IntArray, target: Int, expectedArray: IntArray) {
    val indexes = Solution().twoSum(numbers, target)
    println(indexes.contentEquals(expectedArray))
}

test(intArrayOf(2, 7, 11, 15), target = 9, expectedArray = intArrayOf(1, 2))
test(intArrayOf(2, 3, 4), target = 6, expectedArray = intArrayOf(1, 3))
test(intArrayOf(-1, 0), target = -1, expectedArray = intArrayOf(1, 2))
test(intArrayOf(-3, 3, 4, 90), target = 0, expectedArray = intArrayOf(1, 2))