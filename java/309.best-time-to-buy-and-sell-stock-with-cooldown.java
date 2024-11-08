/*
 * @lc app=leetcode.cn id=309 lang=java
 * @lcpr version=30204
 *
 * [309] 买卖股票的最佳时机含冷冻期
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 0 卖出股票  1 持有股票  2 冷冻期  3 卖出后走出冷冻期
        int length = prices.length;
        int[][] dp = new int[length][4];        
        dp[0][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = dp[i - 1][1] + prices[i];
            dp[i][1] = Math.max(dp[i - 1][1], Math.max(dp[i - 1][3] - prices[i], dp[i - 1][2] -prices[i]));
            dp[i][2] = dp[i - 1][0];
            dp[i][3] = Math.max(dp[i - 1][2], dp[i - 1][3]);
        }
        return Math.max(dp[length - 1][0], Math.max(dp[length - 1][2], dp[length - 1][3]));
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,0,2]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

