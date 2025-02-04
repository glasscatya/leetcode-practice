/*
 * @lc app=leetcode.cn id=79 lang=java
 * @lcpr version=30204
 *
 * [79] 单词搜索
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    //index 单词第几个char  m和n方位
    private boolean dfs(char[][] board, char[] words, int index, int m, int n) {
        //越界
        if (m < 0 || n < 0 || m >= board.length || n >= board[0].length) {
            return false;
        }
        //不是目标
        if (board[m][n] != words[index]) {
            return false;
        }
        //找到了完整单词
        if (index == words.length - 1) {
            return true;
        }
        //是目标 开始搜索下一个char
        board[m][n] = '0'; //记录已经走过的路 防止无限递归
        if (dfs(board, words, index + 1, m - 1, n) ||
            dfs(board, words, index + 1, m + 1, n) ||
            dfs(board, words, index + 1, m, n - 1) ||
            dfs(board, words, index + 1, m, n + 1)) {
            return true;
        }
        board[m][n] = words[index];// 还原现场

        return false;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"\n
// @lcpr case=end

// @lcpr case=start
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"SEE"\n
// @lcpr case=end

// @lcpr case=start
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCB"\n
// @lcpr case=end

 */

