/*
 * @lc app=leetcode.cn id=455 lang=java
 * @lcpr version=30204
 *
 * [455] 分发饼干
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sLen = s.length - 1;
        int ans = 0;
        for (int i = g.length - 1; i >= 0; i--) {
            if (sLen >= 0 && s[sLen] >= g[i]) {
                sLen--;
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3]\n[1,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n[1,2,3]\n
// @lcpr case=end

 */

