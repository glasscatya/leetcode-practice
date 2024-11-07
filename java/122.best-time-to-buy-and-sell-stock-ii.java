/*
 * @lc app=leetcode.cn id=122 lang=java
 * @lcpr version=30204
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        // 1 代表持有某一支股票
        dp[0][1] = -prices[0];
        // 0 代表不持有股票
        dp[0][0] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        }

        return dp[length - 1][0];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [7,1,5,3,6,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3,4,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [7,6,4,3,1]\n
 * // @lcpr case=end
 * 
 */
