/*
 * @lc app=leetcode.cn id=121 lang=java
 * @lcpr version=30204
 *
 * [121] 买卖股票的最佳时机
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    //自己想的 。。。 不确定是贪心还是dp
    public int maxProfit0(int[] prices) {
        int[] dp = new int[prices.length + 1];
        int price = prices[0];
        for (int i = 1; i <= prices.length; i++) {
            if (prices[i - 1] > price) {
                dp[i] = Math.max(dp[i - 1], prices[i - 1] - price);
            } else {
                dp[i] = dp[i - 1];
                price = prices[i - 1];
            }
        }

        return dp[prices.length];
    }
    // 动态规划
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        // 1 代表持有某一支股票
        dp[0][1] = -prices[0];
        // 0 代表不持有股票
        dp[0][0] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
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
 * // [7,6,4,3,1]\n
 * // @lcpr case=end
 * 
 */
