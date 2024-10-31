/*
 * @lc app=leetcode.cn id=518 lang=java
 * @lcpr version=30204
 *
 * [518] 零钱兑换 II
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i] <= j) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 5\n[1, 2, 5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 3\n[2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 10\n[10]\n
 * // @lcpr case=end
 * 
 */
