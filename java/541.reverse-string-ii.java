/*
 * @lc app=leetcode.cn id=541 lang=java
 * @lcpr version=30204
 *
 * [541] 反转字符串 II
 */

// @lcpr-template-start
import java.util.*;

// @lcpr-template-end
// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        for (int i = 0; i < s.length(); i += 2 * k) { // i是第2k+1个元素 因为数组下标0开始
            if (i + k <= s.length()) { // 剩余元素 大于等于 k个 反转，并开始下一轮
                s = reverseString(s, i, i + k - 1);
            } else { // 剩余元素不足k个 反转剩余的全部元素
                s = reverseString(s, i, s.length() - 1);
            }
        }
        return s;
    }

    public String reverseString(String s, int h, int t) {
        StringBuilder sb = new StringBuilder(s);
        int head = h;
        int tail = t;
        char tmp;

        while (head < tail) {
            tmp = sb.charAt(head);
            sb.setCharAt(head, sb.charAt(tail));
            sb.setCharAt(tail, tmp);
            head++;
            tail--;
        }
        return sb.toString();
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "abcdefg"\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "abcd"\n2\n
 * // @lcpr case=end
 * 
 */
