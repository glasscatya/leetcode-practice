/*
 * @lc app=leetcode.cn id=165 lang=java
 * @lcpr version=30204
 *
 * [165] 比较版本号
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("//.");
        String[] v2 = version2.split("//.");
        int n = v1.length;
        int m = v2.length;
        int i = 0,j = 0;
        while (i < n || j < n) {
            int a = 0;
            int b = 0;
            if (i < n) a = Integer.parseInt(v1[i++]); 
            if (j < m) b = Integer.parseInt(v2[j++]);
            if (a != b) return a > b ? 1 : -1;
        }
        return 0;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "1.2"\n"1.10"\n
// @lcpr case=end

// @lcpr case=start
// "1.01"\n"1.001"\n
// @lcpr case=end

// @lcpr case=start
// "1.0"\n"1.0.0.0"\n
// @lcpr case=end

 */

