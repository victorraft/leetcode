class Solution {
    fun moveZeroesEasy(nums: IntArray): Unit {
        val nonZeroNums = nums.filter { it != 0 }
        val nonZeroNumsSize = nonZeroNums.size

        for (i in 0..nums.lastIndex) {
            nums[i] = if (i < nonZeroNumsSize) nonZeroNums[i] else 0
        }
    }

    fun moveZeroes(nums: IntArray): Unit {
        var start = 0
        var end = nums.lastIndex

        while (start < end) {
            if (nums[start] == 0) {
                for (i in start..end - 1) {
                    swap(nums, i, i + 1)
                }
                end--
            } else {
                start++
            }
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}

fun test(nums: IntArray, expectedArray: IntArray) {
    Solution().moveZeroes(nums)
    println(nums.joinToString())
    println(nums.contentEquals(expectedArray))
}

test(intArrayOf(0, 1), expectedArray = intArrayOf(1, 0))
test(intArrayOf(0, 0, 1), expectedArray = intArrayOf(1, 0, 0))
test(intArrayOf(0, 1, 0, 3, 12), expectedArray = intArrayOf(1, 3, 12, 0, 0))
test(intArrayOf(0), expectedArray = intArrayOf(0))