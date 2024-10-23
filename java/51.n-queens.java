/*
 * @lc app=leetcode.cn id=51 lang=java
 * @lcpr version=30204
 *
 * [51] N 皇后
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 初始化棋盘
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTrack(0, n, chessboard);
        return result;
    }

    public void backTrack(int row, int n, char[][] chessboard) {
        if (row == n) {
            result.add(Array2List(chessboard));
            return;
        }

        for(int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backTrack(row + 1, n, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i = 0; i < row; i++) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 4\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 1\n
 * // @lcpr case=end
 * 
 */
