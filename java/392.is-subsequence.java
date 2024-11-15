/*
 * @lc app=leetcode.cn id=392 lang=java
 * @lcpr version=30204
 *
 * [392] 判断子序列
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        char c;
        for (int i = 1; i <= s.length(); i++) {
            c = s.charAt(i - 1);
            for (int j = 1; j<= t.length(); j++) {
                if (c == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];// t这一行当前字符被忽略
                    //在dp中 只要使用类似于 j-1 这种略过某一元素
                    //其实就可以滤过无数个元素 能够找到不相连的情况
                }
            }
        }
        return dp[s.length()][t.length()] == s.length() ? true : false;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "abc"\n"ahbgdc"\n
// @lcpr case=end

// @lcpr case=start
// "axc"\n"ahbgdc"\n
// @lcpr case=end

 */

