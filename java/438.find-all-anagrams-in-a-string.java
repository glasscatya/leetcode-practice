/*
 * @lc app=leetcode.cn id=438 lang=java
 * @lcpr version=30204
 *
 * [438] 找到字符串中所有字母异位词
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] alph = new int[26];
        for (int i = 0; i < p.length(); i++) {
            alph[s.charAt(i) - 'a']++;
        }  
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'a';
            alph[index]--;// 消耗掉一个字母
            //当消耗掉的字母数量超出拥有的字母
            while (alph[index] < 0) {
                alph[s.charAt(left) - 'a']++; // 滑动left窗口 把消耗还回去
                left++;
            }
            //出循环时 我们拥有的字母一定是 >= 0的 
            // 当窗口大小等于目标字符串长度 则一定是出现了异位词
            if (right - left + 1 == p.length()) {
                ans.add(left);
            }
        }
        return ans;
    }



    public List<Integer> findAnagrams_0(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int pLen = p.length();
        for (int i = 0; i < s.length() - pLen + 1; i++) {
            if (isAnagram(s.substring(i, i + pLen), p)) {
                ans.add(i);
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
// "cbaebabacd"\n"abc"\n
// @lcpr case=end

// @lcpr case=start
// "abab"\n"ab"\n
// @lcpr case=end

 */

