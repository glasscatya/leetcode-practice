/*
 * @lc app=leetcode.cn id=494 lang=java
 * @lcpr version=30204
 *
 * [494] 目标和
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if ((sum + target) % 2 != 0)
            return 0;
        if (Math.abs(target) > sum)
            return 0; // 此时没有方案
        int total = (sum + target) / 2;

        int[][] dp = new int[nums.length][total + 1];
        // dp[i][j]: 从0-i中选任意个不重复物品，有多少种方式可以填满j。
        // 初始化第一行
        if (nums[0] <= total) {
            dp[0][nums[0]] = 1;
        }

        // 初始化第一列
        int zeroValue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroValue++;
            dp[i][0] = (int) Math.pow(2, zeroValue);
        }
        //
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][total];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,1,1,1,1]\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n1\n
 * // @lcpr case=end
 * 
 */
