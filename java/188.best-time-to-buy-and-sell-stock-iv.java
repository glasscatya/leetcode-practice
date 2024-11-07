/*
 * @lc app=leetcode.cn id=188 lang=java
 * @lcpr version=30204
 *
 * [188] 买卖股票的最佳时机 IV
 */
// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][k * 2 + 1];
        for (int j = 1; j < (k * 2 + 1); j += 2) {
            dp[0][j] = -prices[0];
        }
        // k = 2  5  1第一次 3第二次 5无 
        for (int i = 1; i < length; i++) {
            for (int j = 0; j + 2 < (k * 2 + 1); j++) {
                //j为偶数是卖出 j为奇数是持有
                // if (j % 2 == 0) {
                //     dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                // } else {
                //     dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                // }
                //j + 1奇数  j + 2 偶数
                dp[i][j + 1] = Math.max(dp[i - 1][j - 1], dp[i - 1][j - 1] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j - 1], dp[i - 1][j - 1] + prices[i]);
            }
        }

        return dp[length - 1][k * 2 + 1];
    }
}
// @lc code=end



/*
// @lcpr case=start
// 2\n[2,4,1]\n
// @lcpr case=end

// @lcpr case=start
// 2\n[3,2,6,5,0,3]\n
// @lcpr case=end

 */

