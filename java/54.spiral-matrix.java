/*
 * @lc app=leetcode.cn id=54 lang=java
 * @lcpr version=30204
 *
 * [54] 螺旋矩阵
 */

// @lcpr-template-start
import java.util.*;

// @lcpr-template-end
// @lc code=start
class Solution {                        // 第一位正 向下  第二位正向右
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
                                        // 用二维数组代表 移动方向 
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>(m * n);
        int i = 0;
        int j = -1;
        int size = m * n;
        for (int di = 0; ans.size() < size; di = (di + 1) % 4) {
            for (int k = 0; k < n; k++) {
                i += DIRS[di][0];
                j += DIRS[di][1];
                ans.add(matrix[i][j]);
            }
            // 互换m与n 并且每次掉头 都让当前n - 1
            // 每轮循环掉头两次 刚好是 - 2 
            int tmp = n;
            n = m - 1;
            m = tmp;
        }
        return ans;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,2,3],[4,5,6],[7,8,9]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,2,3,4],[5,6,7,8],[9,10,11,12]]\n
 * // @lcpr case=end
 * 
 */
