/*
 * @lc app=leetcode.cn id=59 lang=java
 * @lcpr version=30204
 *
 * [59] 螺旋矩阵 II
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int startx = 0, starty = 0;
        int loop = 1; // 每个圈循环几次，例如n为奇数3，那么loop = 1 只是循环一圈，矩阵中间的值需要单独处理
        int i,j;
        int count = 1; // 要填入的数字
        int offset = 1; // 每过一轮 范围小一圈
        int mid = n / 2;
        while (loop <= n / 2) {
            for (j = starty; j < n - offset; j++) 
                ans[startx][j] = count++;
            for (i = startx; i < n - offset; i++)
                ans[i][j] = count++;
            for (; j > starty; j--)
                ans[i][j] = count++;
            for (; i > startx; i--)
                ans[i][j] = count++;

            startx++;
            starty++;
            offset++;
            loop++;
        }
        if (n % 2 == 1) {
            ans[mid][mid] = count;
        }

        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

