/*
 * @lc app=leetcode.cn id=322 lang=java
 * @lcpr version=30204
 *
 * [322] 零钱兑换
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = Integer.MAX_VALUE;
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) 
            dp[i] = max;

        for (int j = 1; j <= amount; j++) {
            for (int coin : coins) {
                //这里是 首先楼层要>=步长 
                //其次是新起点需要是可抵达的 表现为不为初始值。
                if (j >= coin && (dp[j - coin] != max))
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1, 2, 5]\n11\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2]\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n0\n
 * // @lcpr case=end
 * 
 */
