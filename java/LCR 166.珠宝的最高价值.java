/*
 * @lc app=leetcode.cn id=LCR 166 lang=java
 * @lcpr version=30204
 *
 * [LCR 166] 珠宝的最高价值
 */

// @lcpr-template-start
import java.util.*;

// @lcpr-template-end
// @lc code=start
class Solution {
    public int jewelleryValue(int[][] frame) {
        int[][] dp = new int[frame.length][frame[0].length];
        dp[0][0] = frame[0][0];
        for (int i = 1; i < frame.length; i++) {
            dp[i][0] = frame[i][0] + dp[i - 1][0];
        }
        for (int j = 1; j < frame[0].length; j++) {
            dp[0][j] = frame[0][j] + dp[0][j - 1];
        }

        for (int i = 1; i < frame.length; i++) {
            for (int j = 1; j < frame[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + frame[i][j];
            }
        }
        return dp[frame.length - 1][frame[0].length - 1];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,3,1],[1,5,1],[4,2,1]]\n
 * // @lcpr case=end
 * 
 */
