/*
 * @lc app=leetcode.cn id=9 lang=java
 * @lcpr version=30204
 *
 * [9] 回文数
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int newX = 0;
        int tmp = x;
        while(tmp != 0) {
            newX = newX * 10 + tmp % 10;
            tmp /= 10;
        }
        return newX == x;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 121\n
// @lcpr case=end

// @lcpr case=start
// -121\n
// @lcpr case=end

// @lcpr case=start
// 10\n
// @lcpr case=end

 */

