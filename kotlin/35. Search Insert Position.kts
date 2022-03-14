/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size

        while (left < right) {
            val middleIndex = left + (right - left) / 2
            val middleValue = nums[middleIndex]

            when {
                target == middleValue ->
                    return middleIndex

                target > middleValue -> {
                    left = middleIndex + 1
                }

                target < middleValue -> {
                    right = middleIndex
                }
            }
        }

        return left
    }
}
