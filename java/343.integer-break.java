/*
 * @lc app=leetcode.cn id=343 lang=java
 * @lcpr version=30204
 *
 * [343] 整数拆分
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                dp[i] = (dp[i] >= (j*(i-j) > j*dp[i-j] ? j*(i-j) : j*dp[i-j])) ? 
                        dp[i] : (j*   (i-j) > j*dp[i-j] ? j*(i-j) : j*dp[i-j]);
                //调用库会慢一点 二者语义等价
                //dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
        }
        return dp[n];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 10\n
 * // @lcpr case=end
 * 
 */
