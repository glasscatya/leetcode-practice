/*
 * @lc app=leetcode.cn id=474 lang=java
 * @lcpr version=30204
 *
 * [474] 一和零
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int x;
        int y;
        // dp初始化为全0️⃣
        for (String str : strs) {
            x = 0;
            y = 0;
            for (char c : str.toCharArray()) {
                if (c == '0')
                    x++;
                else
                    y++;
            }
            for (int i = m; i >= x; i--) {
                for (int j = n; j >= y; j--) {
                    dp[i][j] = (dp[i][j] < dp[i - x][j - y] + 1) ? dp[i - x][j - y] + 1 : dp[i][j];
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // ["10", "0001", "111001", "1", "0"]\n5\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // ["10", "0", "1"]\n1\n1\n
 * // @lcpr case=end
 * 
 */
