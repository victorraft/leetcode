class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        if (nums.size <= 1) {
            return
        }

        val optimizedK = k % nums.size
        val breakIndex = nums.lastIndex - optimizedK

        reverse(nums, 0, breakIndex)
        reverse(nums, breakIndex + 1, nums.lastIndex)
        reverse(nums, 0, nums.lastIndex)
    }

    private fun reverse(nums: IntArray, from: Int, to: Int) {
        var start = from
        var end = to

        while (start < end) {
            val temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            start++
            end--
        }
    }
}

fun test(nums: IntArray, k: Int, expectedArray: IntArray) {
    Solution().rotate(nums, k)
    println(nums.contentEquals(expectedArray))
}

test(intArrayOf(1, 2), 3, expectedArray = intArrayOf(2, 1))
test(intArrayOf(1), 2, expectedArray = intArrayOf(1))
test(intArrayOf(1, 2, 3, 4, 5, 6, 7), 1, expectedArray = intArrayOf(7, 1, 2, 3, 4, 5, 6))
test(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3, expectedArray = intArrayOf(5, 6, 7, 1, 2, 3, 4))
test(intArrayOf(-1, -100, 3, 99), 2, expectedArray = intArrayOf(3, 99, -1, -100))
