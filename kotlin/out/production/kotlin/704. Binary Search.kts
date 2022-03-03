class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val middle = left + (right - left) / 2
            val middleValue = nums[middle]

            when {
                middleValue == target -> return middle
                target > middleValue -> left = middle + 1
                target < middleValue -> right = middle - 1
            }
        }

        return -1
    }
}
