/*
 * @lc app=leetcode.cn id=22 lang=java
 * @lcpr version=30204
 *
 * [22] 括号生成
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    private List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        //合法的括号总是满足，1.左右括号数量相等 2.每个右括号前总有左括号
        dfs(n, n, "");
        return ans;
    }
    private void dfs(int left, int right, String cur) {
        //所有左右括号耗尽，收集答案
        if (left == 0 && right == 0) {
            ans.add(cur);
        }
        //优先消耗左括号
        if (left > 0) {
            dfs(left - 1, right, cur + "(");
        }
        //右括号总是后消耗
        if (right > left) {
            dfs(left, right - 1, cur + ")");
        }
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

