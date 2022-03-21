class Solution {
    // TODO improve it. this solution is better than 48%.
    fun rotate(nums: IntArray, k: Int): Unit {
        if (nums.size <= 1) {
            return
        }

        val correctedK = k % nums.size

        val startArray = nums.sliceArray(0..nums.size - 1 - correctedK)
        val endArray = nums.sliceArray((nums.size - correctedK)..nums.size - 1)
        val resultArray = endArray + startArray

        for (i in nums.indices) {
            nums[i] = resultArray[i]
        }
    }
}

fun test(nums: IntArray, k: Int, expectedArray: IntArray) {
    Solution().rotate(nums, k)
//    println(nums.joinToString())
    println(nums.contentEquals(expectedArray))
}

test(intArrayOf(1, 2), 3, expectedArray = intArrayOf(2, 1))
test(intArrayOf(1), 2, expectedArray = intArrayOf(1))
test(intArrayOf(1, 2, 3, 4, 5, 6, 7), 1, expectedArray = intArrayOf(7, 1, 2, 3, 4, 5, 6))
test(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3, expectedArray = intArrayOf(5, 6, 7, 1, 2, 3, 4))
test(intArrayOf(-1, -100, 3, 99), 2, expectedArray = intArrayOf(3, 99, -1, -100))
