/*
 * @lc app=leetcode.cn id=647 lang=java
 * @lcpr version=30204
 *
 * [647] 回文子串
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        byte[][] dp = new byte[s.length()][s.length()];
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = 1;
                        result++;
                        //这里的i + 1永远不会出现越界的情况
                        // 因为i = s.length() - 1, j = i时，永远只会执行上面逻辑
                    } else if (dp[i + 1][j - 1] == 1) {
                        dp[i][j] = 1;
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "abc"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "aaa"\n
 * // @lcpr case=end
 * 
 */
