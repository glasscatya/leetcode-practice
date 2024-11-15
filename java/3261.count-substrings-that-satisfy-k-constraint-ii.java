/*
 * @lc app=leetcode.cn id=3261 lang=java
 * @lcpr version=30204
 *
 * [3261] 统计满足 K 约束的子字符串数量 II
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    int zeros = 0;
    int ones = 0;
    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        long[] ans = new long[queries.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = countSubstrings(s, k, queries[i][0], queries[i][1]);
            zeros = 0;
            ones = 0;
        }
        return ans;
    }

    public long countSubstrings(String s, int k, int leftLimit, int rightLimit) {
        int ans = 0;
        int left = leftLimit;
        int right = leftLimit;
        while (right < rightLimit + 1) {
            if (s.charAt(right) == '1') {
                ones++;
            } else {
                zeros++;
            }

            while (ones > k && zeros > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                } else {
                    zeros--;
                }
                left++;
            }
            ans += right - left + 1; // left 到 right 中所有可能的子串;
            right++;
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "0001111"\n2\n[[0,6]]\n
// @lcpr case=end

// @lcpr case=start
// "010101"\n1\n[[0,5],[1,4],[2,3]]\n
// @lcpr case=end

 */

