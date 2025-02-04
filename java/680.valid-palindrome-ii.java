/*
 * @lc app=leetcode.cn id=680 lang=java
 * @lcpr version=30204
 *
 * [680] 验证回文串 II
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length();
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end - 1)) {
                return isPalindrome(start + 1, end, s) || isPalindrome(start, end - 1, s);
            }
            start++;
            end--;
        }
        return true;
    }
    //[start, end)
    private boolean isPalindrome(int start, int end, String s) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end - 1)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "aba"\n
// @lcpr case=end

// @lcpr case=start
// "abca"\n
// @lcpr case=end

// @lcpr case=start
// "abc"\n
// @lcpr case=end

 */

