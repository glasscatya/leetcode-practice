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

    //移除所有*多余*的空格
    //使用快慢指针 ： 慢指针放在需要被替换的位置 快指针放在第一个可以替换的位置
    public char[] removeExtraSpaces(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            // 快指针遇到可以替换的单词
            if (chars[fast] != ' ') {
                if (slow != 0)
                    chars[slow++] = ' ';// 除了开头的单词之外，单词之间都要有一个空格
                // 用while保证一个单词替换完成
                while (fast < chars.length && chars[fast] != ' ') {
                    chars[slow++] = chars[fast++];
                }
            }
        }
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
        //交换一个单词的顺序 单词以空格为分界
        for (int end = 0; end <= chars.length; end++) {
            //遇到空格 就说明走到一个单词的尽头了 或者 end走到了最后一个单词的尽头
            if (end == chars.length || chars[end] == ' ') {
                //我实现的反转字符串是 左闭右闭的[]   一般官方库是左闭右开[)
                reverseString(chars, start, end - 1);
                // end刚好在空格 新单词的起始位置在空格后一格
                start = end + 1;
            }
        }
    }
}


/**
class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        //移出多余的空格
        chars = removeExtraSpaces(chars);
        //反转字符串
        reverseString(chars, 0, chars.length - 1);
        //二次反转字符串中的每个单词
        reverseEachWords(chars);
        return new String(chars);
    }

    private char[] removeExtraSpaces(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != ' ') {
                if (slow > 0) chars[slow++] = ' ';

                while (fast < chars.length && chars[fast] != ' ') 
                    chars[slow++] = chars[fast++];
            }
        }
        char[] newChars = new char[slow];
        System.arraycopy(chars, 0, newChars, 0, slow); 
        return newChars;
    }

    private void reverseString(char[] chars, int s, int e) {
        int start = s;
        int end = e;
        while (end > start) {
            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }

    private void reverseEachWords(char[] chars) {
        int start = 0;
        for (int end = 0; end <= chars.length; end++) {
            if (end == chars.length || chars[end] == ' ') {
                reverseString(chars, start, end - 1);
                start = end + 1;
            }
        }
    }
}
 */
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
