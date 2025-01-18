/*
 * @lc app=leetcode.cn id=263 lang=java
 * @lcpr version=30204
 *
 * [263] 丑数
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        int[] prime = new int[] {2, 3, 5};
        for (int i : prime) {
            //当n能被i整除
            while (n % i == 0) {
                n /= i;
            }
        }
        return n == 1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 6\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

// @lcpr case=start
// 14\n
// @lcpr case=end

 */

