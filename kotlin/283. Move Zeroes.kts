class Solution {
    // TODO pretty bad solution. Improve it using two pointers.
    fun moveZeroes(nums: IntArray): Unit {
        for (i in 0..nums.lastIndex - 1) {
            for (j in 0..nums.lastIndex - 1) {
                if (nums[j] == 0) {
                    swap(nums, j, j + 1)
                }
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
