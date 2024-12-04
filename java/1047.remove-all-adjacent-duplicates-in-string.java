/*
 * @lc app=leetcode.cn id=1047 lang=java
 * @lcpr version=30204
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lcpr-template-start
import java.io.CharArrayReader;
import java.text.Collator;
import java.util.*;

// @lcpr-template-end
// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        // 使用字符数组作为栈，避免使用 Deque 和 Stream，提高性能
        char[] stack = new char[s.length()];
        int top = -1; // 模拟栈顶指针

        for (char c : s.toCharArray()) {
            if (top >= 0 && stack[top] == c) {
                // 当前字符与栈顶字符相同，出栈
                top--;
            } else {
                // 否则，入栈
                stack[++top] = c;
            }
        }

        // 根据栈内字符构造结果字符串
        return new String(stack, 0, top + 1);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "abbaca"\n
 * // @lcpr case=end
 * 
 */
