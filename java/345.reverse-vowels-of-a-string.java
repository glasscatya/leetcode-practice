/*
 * @lc app=leetcode.cn id=345 lang=java
 * @lcpr version=30204
 *
 * [345] 反转字符串中的元音字母
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        StringBuilder sb = new StringBuilder(s);
        int head = 0;
        int tail = sb.length() - 1;
        while (head < tail) {
            // 移动左指针，直到找到元音字母
            while (head < tail && !vowels.contains(sb.charAt(head))) {
                head++;
            }
            // 移动右指针，直到找到元音字母
            while (head < tail && !vowels.contains(sb.charAt(tail))) {
                tail--;
            }
            if (head < tail) {
                char temp = sb.charAt(head);
                sb.setCharAt(head, sb.charAt(tail));
                sb.setCharAt(tail, temp);
                head++;
                tail--;
            }
        }
        return sb.toString();
    }
}
// @lc code=end



/*
// @lcpr case=start
// "IceCreAm"\n
// @lcpr case=end

// @lcpr case=start
// "leetcode"\n
// @lcpr case=end

 */

