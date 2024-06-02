/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];

        for(int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int eq : record) {
            if(eq != 0)
              return false;
        }

        return true;
    }
}
// @lc code=end

