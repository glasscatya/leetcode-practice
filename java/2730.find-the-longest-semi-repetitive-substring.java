/*
 * @lc app=leetcode.cn id=2730 lang=java
 * @lcpr version=30204
 *
 * [2730] 找到最长的半重复子字符串
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        if (s.length() < 3) return s.length();
        int left = 0;
        boolean hasAdjacentDuplicates = s.charAt(0) == s.charAt(1);
        int max = 2;
        for (int right = 2; right < s.length(); right++) {
            if (s.charAt(right) == s.charAt(right - 1)) {
                if (hasAdjacentDuplicates) {
                    while (hasAdjacentDuplicates) {
                        if (s.charAt(left) == s.charAt(left + 1)) {
                            hasAdjacentDuplicates = false;
                        }
                        left++;
                    }
                }
                hasAdjacentDuplicates = true;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "52233"\n
// @lcpr case=end

// @lcpr case=start
// "5494"\n
// @lcpr case=end

// @lcpr case=start
// "1111111"\n
// @lcpr case=end

 */

