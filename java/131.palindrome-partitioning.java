/*
 * @lc app=leetcode.cn id=131 lang=java
 * @lcpr version=30204
 *
 * [131] 分割回文串
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> path = new ArrayList<>();
    private List<List<String>> result = new ArrayList<>();
    private int startIndex = 0;

    public List<List<String>> partition(String s) {
        // 回溯
        backtrack(s, new StringBuilder(), startIndex);
        return result;
    }

    public void backtrack(String s, StringBuilder sb, int startIndex) {
        // 终止条件 说明这个“起点”的所有可能都已经找完
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(path));
            return ;
        }

        // 单层遍历逻辑
        /*
         * startIndex是每次搜索的起点，也就是分割字符串的起点
         * i是分割字符串的终点 i不断增大，直到字符串的末尾。
         * 走遍从**这次起点**到终点的所有可能
         */
        for (int i = startIndex; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (check(sb)) {
                path.add(sb.toString());
                backtrack(s, new StringBuilder(), i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    // helper method, 检查是否是回文
    //时间大头花在这 可以使用动态规划优化它 but我不会hhh
    //TODO:动态规划
    private boolean check(StringBuilder sb) {
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "aab"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "a"\n
 * // @lcpr case=end
 * 
 */
