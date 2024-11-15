/*
 * @lc app=leetcode.cn id=1035 lang=java
 * @lcpr version=30204
 *
 * [1035] 不相交的线
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,4,2]\n[1,2,4]\n
// @lcpr case=end

// @lcpr case=start
// [2,5,1,2,5]\n[10,5,2,1,5,2]\n
// @lcpr case=end

// @lcpr case=start
// [1,3,7,1,7,5]\n[1,9,2,5,1]\n
// @lcpr case=end

 */

