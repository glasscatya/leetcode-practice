/*
 * @lc app=leetcode.cn id=63 lang=java
 * @lcpr version=30204
 *
 * [63] 不同路径 II
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 在递推公式中加一层判断 如果路径中有障碍物 则该路径失效
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 初始化 初始化过程中 有障碍物 后续所有点无效；
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
                break;
            }
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[0,0,0],[0,1,0],[0,0,0]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[0,1],[0,0]]\n
 * // @lcpr case=end
 * 
 */
