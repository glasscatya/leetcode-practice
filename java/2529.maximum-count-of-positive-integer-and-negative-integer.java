/*
 * @lc app=leetcode.cn id=2529 lang=java
 * @lcpr version=30204
 *
 * [2529] 正整数和负整数的最大计数
 */

// @lcpr-template-start
import java.util.*;

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maximumCount(int[] nums) {
        int neg = lowerBound(nums, 0);
        int pos = nums.length - lowerBound(nums, 1);
        return Math.max(neg, pos);
    }
    private int lowerBound(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [-2,-1,-1,1,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-3,-2,-1,0,0,1,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5,20,66,1314]\n
 * // @lcpr case=end
 * 
 */
