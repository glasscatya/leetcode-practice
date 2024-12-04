/*
 * @lc app=leetcode.cn id=242 lang=java
 * @lcpr version=30204
 *
 * [242] 有效的字母异位词
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] hashArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hashArr[s.charAt(i) - 'a']++;
        }   

        for (int j = 0; j < t.length(); j++) {
            hashArr[t.charAt(j) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (hashArr[i] != 0)
                return false;
        }
        return true;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "anagram"\n"nagaram"\n
// @lcpr case=end

// @lcpr case=start
// "rat"\n"car"\n
// @lcpr case=end

 */

