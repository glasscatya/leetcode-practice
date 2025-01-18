/*
 * @lc app=leetcode.cn id=2273 lang=java
 * @lcpr version=30204
 *
 * [2273] 移除字母异位词后的结果数组
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        int slow = 0;
        ans.add(words[slow]);
        for (int fast = 1; fast < words.length; fast++) {
            if (!isAnagram(words[slow], words[fast])) {
                slow = fast;
                ans.add(words[slow]);
            }
        }
        return ans;
    }

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
// ["abba","baba","bbaa","cd","cd"]\n
// @lcpr case=end

// @lcpr case=start
// ["a","b","c","d","e"]\n
// @lcpr case=end

 */

