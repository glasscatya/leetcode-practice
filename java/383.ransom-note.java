/*
 * @lc app=leetcode.cn id=383 lang=java
 * @lcpr version=30204
 *
 * [383] 赎金信
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] aph = new int[26];
        for (char c : magazine.toCharArray()) {
            aph[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            // aph[c - 'a']--;
            if (aph[c - 'a']-- < 0) {
                return false;
            }
        }
        // return Arrays.stream(aph).allMatch(i -> i >= 0);
        return true;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "a"\n"b"\n
// @lcpr case=end

// @lcpr case=start
// "aa"\n"ab"\n
// @lcpr case=end

// @lcpr case=start
// "aa"\n"aab"\n
// @lcpr case=end

 */

