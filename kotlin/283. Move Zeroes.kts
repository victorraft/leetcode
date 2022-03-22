class Solution {
    fun moveZeroesEasy(nums: IntArray): Unit {
        val nonZeroNums = nums.filter { it != 0 }
        val nonZeroNumsSize = nonZeroNums.size

        for (i in 0..nums.lastIndex) {
            nums[i] = if (i < nonZeroNumsSize) nonZeroNums[i] else 0
        }
    }

    // Push the non-zero elements to the front of the array, and fill the back with zeroes.
    fun moveZeroesPushingNonZeroesToFront(nums: IntArray): Unit {
        var lastNonZeroIndex = 0

        for (i in 0..nums.lastIndex) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex] = nums[i]
                lastNonZeroIndex++
            }
        }

        for (i in lastNonZeroIndex..nums.lastIndex) {
            nums[i] = 0
        }
    }

    fun moveZeroes(nums: IntArray): Unit {
        var lastNonZeroIndex = 0

        for (i in 0..nums.lastIndex) {
            if (nums[i] != 0) {
                val temp = nums[i]
                nums[i] = 0
                nums[lastNonZeroIndex] = temp
                lastNonZeroIndex++
            }
        }
    }
}

fun test(nums: IntArray, expectedArray: IntArray) {
    Solution().moveZeroes(nums)
    println(nums.contentEquals(expectedArray))
}

test(intArrayOf(0, 1), expectedArray = intArrayOf(1, 0))
test(intArrayOf(0, 0, 1), expectedArray = intArrayOf(1, 0, 0))
test(intArrayOf(0, 1, 0, 3, 12), expectedArray = intArrayOf(1, 3, 12, 0, 0))
test(intArrayOf(0), expectedArray = intArrayOf(0))