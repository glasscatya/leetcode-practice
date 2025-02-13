/*
 * @lc app=leetcode.cn id=130 lang=java
 * @lcpr version=30204
 *
 * [130] 被围绕的区域
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) return;
        int m = board.length;
        int n = board[0].length;

        //找到符合条件的'O'改成'#'
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int j = 0; j < board[0].length; j++) {
            dfs(board, m - 1, j);
            dfs(board, 0, j);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int m, int n) {
        //越界
        if (m < 0 || m >= board.length || n < 0 || n >= board[0].length) return;
        //已经扫描过或不是目标
        if (board[m][n] != 'O') return;
        board[m][n] = '#';

        dfs(board, m - 1, n);//上
        dfs(board, m + 1, n);//下
        dfs(board, m, n - 1);//左
        dfs(board, m, n + 1);//右
    }
}
// @lc code=end



/*
// @lcpr case=start
// [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]\n
// @lcpr case=end

// @lcpr case=start
// [["X"]]\n
// @lcpr case=end

 */

