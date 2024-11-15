/*
 * @lc app=leetcode.cn id=115 lang=java
 * @lcpr version=30204
 *
 * [115] 不同的子序列
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        // s 中删除元素变成 t，有几种可能？
        // for (int j = 0; j < t.length(); j++)
        // dp[0][j] = 0; //s为空字符串时，s不能变成t(除了dp[0][0])
        for (int i = 0; i <= s.length(); i++)
            dp[i][0] = 1; // t为空字符串时，s有一种可能变成t

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // 删除第i个char
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "rabbbit"\n"rabbit"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "babgbag"\n"bag"\n
 * // @lcpr case=end
 * 
 */
