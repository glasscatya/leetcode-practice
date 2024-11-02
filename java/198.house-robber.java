/*
 * @lc app=leetcode.cn id=198 lang=java
 * @lcpr version=30204
 *
 * [198] 打家劫舍
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,7,9,3,1]\n
 * // @lcpr case=end
 * 
 */
