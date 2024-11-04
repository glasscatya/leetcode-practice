/*
 * @lc app=leetcode.cn id=139 lang=java
 * @lcpr version=30204
 *
 * [139] 单词拆分
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        // dp[i]:从0-i的字符可以被wordDict表示
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    //回溯 TODO:
    public boolean wordBreak2(String s, List<String> wordDict) {
        String[] dp = new String[wordDict.size()];
        for (int i = 1; i < wordDict.size(); i++) {
            for (String word : wordDict) {
                dp[i] = dp[i - 1] + word;
                if (dp[i].equals(s))
                    return true;
            }
        }
        return false;
    }
}

// @lc code=end

/*
 * // @lcpr case=start
 * // "leetcode"\n["leet", "code"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "applepenapple"\n["apple", "pen"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "catsandog"\n["cats", "dog", "sand", "and", "cat"]\n
 * // @lcpr case=end
 * 
 */
