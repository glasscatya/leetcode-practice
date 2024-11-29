/*
 * @lc app=leetcode.cn id=151 lang=java
 * @lcpr version=30204
 *
 * [151] 反转字符串中的单词
 */

// @lcpr-template-start
import java.util.*;

// @lcpr-template-end
// @lc code=start
class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        chars = removeExtraSpaces(chars);
        reverseString(chars, 0, chars.length - 1);
        reverseEachWords(chars);
        return new String(chars);
    }

    public char[] removeExtraSpaces(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != ' ') {
                if (slow != 0)
                    chars[slow++] = ' ';// 除了开头的单词之外，单词之间都要有一个空格
                while (fast < chars.length && chars[fast] != ' ') {
                    chars[slow++] = chars[fast++];
                }
            }
        }
       //相当于 c++ 里的 resize()
       char[] newChars = new char[slow];
       System.arraycopy(chars, 0, newChars, 0, slow); 
       return newChars;
    }

    public void reverseString(char[] chars, int s, int e) {
        int start = s;
        int end = e;
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end++;
        }
    }

    public void reverseEachWords(char[] chars) {
        int start = 0;
        for (int end = 0; end <= chars.length; end++) {
            if (end == chars.length || chars[end] == ' ') {
                reverseString(chars, start, end - 1);
                start = end + 1;
            }
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "the sky is blue"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "  hello world  "\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "a good   example"\n
 * // @lcpr case=end
 * 
 */
