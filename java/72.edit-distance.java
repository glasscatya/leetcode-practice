/*
 * @lc app=leetcode.cn id=72 lang=java
 * @lcpr version=30204
 *
 * [72] 编辑距离
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {        
                    //分别对应 删word1  删word2 替 这三种情况
                    // 其中插入与删除是对称操作 对w1插入字符与对w2删除该字符 效果一致 
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, 
                               Math.min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "horse"\n"ros"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "intention"\n"execution"\n
 * // @lcpr case=end
 * 
 */
