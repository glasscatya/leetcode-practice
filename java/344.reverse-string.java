/*
 * @lc app=leetcode.cn id=344 lang=java
 * @lcpr version=30204
 *
 * [344] 反转字符串
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        int head = 0;
        int tail = s.length - 1;
        char tmp;

        while (head < tail) {
            tmp = s[head];
            s[head] = s[tail];
            s[tail] = tmp;
            head++;
            tail--;
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// ["h","e","l","l","o"]\n
// @lcpr case=end

// @lcpr case=start
// ["H","a","n","n","a","h"]\n
// @lcpr case=end

 */

