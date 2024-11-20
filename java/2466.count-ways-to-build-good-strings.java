/*
 * @lc app=leetcode.cn id=2466 lang=java
 * @lcpr version=30204
 *
 * [2466] 统计构造好字符串的方案数
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    private static final int MOD = 1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int result = 0;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) dp[i] += dp[i - zero];
            if (i >= one) dp[i] += dp[i - one];
            dp[i] %= MOD; // ????
        }

        for (int i = low; i <= high; i++) {
            result += dp[i];
            result %= MOD;
        }

        return result;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 3\n3\n1\n1\n
// @lcpr case=end

// @lcpr case=start
// 2\n3\n1\n2\n
// @lcpr case=end

 */

