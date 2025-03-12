/*
 * @lc app=leetcode.cn id=2698 lang=java
 * @lcpr version=30204
 *
 * [2698] 求一个整数的惩罚数
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        //1 <= i <= n都是成立的
        for (int i = 1; i <= n; i++) {
            if (dfs(0, String.valueOf(i * i), 0, i)) {
                ans += i * i;
            }
        }
        return ans;
    }
    //分割字符串
    //验证第二的条件
    // 传入 i + 1是从下一个开始取值 传入 startIndex + 1意味着与j当前位置无关
    private boolean dfs (int startIndex, String num, int curr, int target) {
        if (startIndex == num.length()) {
            return curr == target;
        }
        for (int i = startIndex; i < num.length(); i++) {
            int tmp = Integer.parseInt(num.substring(startIndex, j + 1));
            if (dfs(i + 1, num, curr + tmp, target)) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 10\n
// @lcpr case=end

// @lcpr case=start
// 37\n
// @lcpr case=end

 */

