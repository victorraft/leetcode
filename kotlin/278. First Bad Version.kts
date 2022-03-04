/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

class Solution : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var left = 1
        var right = n

        while (left < right) {
            val middle = left + (right - left) / 2

            when {
                isBadVersion(middle) -> right = middle
                else -> left = middle + 1
            }
        }

        return left
    }
}
