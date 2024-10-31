/*
 * @lc app=leetcode.cn id=64 lang=java
 * @lcpr version=30204
 *
 * [64] 最小路径和
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) 
            dp[i][0] = grid[i][0] + dp[i-1][0];
    
        for (int j = 1; j < n; j++)
            dp[0][j] = grid[0][j] + dp[0][j-1];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,3,1],[1,5,1],[4,2,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,2,3],[4,5,6]]\n
// @lcpr case=end

 */

