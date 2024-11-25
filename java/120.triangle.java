/*
 * @lc app=leetcode.cn id=120 lang=java
 * @lcpr version=30204
 *
 * [120] 三角形最小路径和
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int maxCol = triangle.get(row - 1).size();
        int[] dp = new int[maxCol];
        dp[0] = triangle.get(0).get(0);
        int ans = dp[0];
        for (int i = 1; i < row; i++) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = dp[j] + triangle.get(i).get(j);
                    continue;
                }
                if (dp[j] == 0) {
                    dp[j] = dp[j - 1] +triangle.get(i).get(j);
                }
                dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
            }
        }
        for (int i : dp) {
            if (i < ans) ans = i;
        }
        return ans;
    }
}








// @lc code=end



/*
// @lcpr case=start
// [[2],[3,4],[6,5,7],[4,1,8,3]]\n
// @lcpr case=end

// @lcpr case=start
// [[-10]]\n
// @lcpr case=end

 */

