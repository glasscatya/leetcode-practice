/*
 * @lc app=leetcode.cn id=516 lang=java
 * @lcpr version=30204
 *
 * [516] 最长回文子序列
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // dp[i][j] 表示 s[i..j] 的最长回文子序列长度
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1; // 单个字符的回文子序列长度为1
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2; // 首尾字符相同
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]); // 首尾字符不同，取较大者
                }
            }
        }
        return dp[0][n - 1]; // 返回整个字符串的最长回文子序列长度
    }
}
// @lc code=end



/*
// @lcpr case=start
// "bbbab"\n
// @lcpr case=end

// @lcpr case=start
// "cbbd"\n
// @lcpr case=end

 */

