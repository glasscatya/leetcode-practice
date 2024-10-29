/*
 * @lc app=leetcode.cn id=416 lang=java
 * @lcpr version=30204
 *
 * [416] 分割等和子集
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

class Solution {
    public boolean canPartition(int[] nums) {
        // 不存在返回false
        if (nums == null || nums.length == 0)
            return false;
        int sum = 0;
        for (int num : nums)
            sum += num;
        // 无法被整除 返回false
        int target = sum >> 1;
        if (target << 1 != sum)
            return false;
        int[] dp = new int[target + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            if (dp[target] == target)
                return true;
        }
        return dp[target] == target;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,5,11,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3,5]\n
 * // @lcpr case=end
 * 
 */
