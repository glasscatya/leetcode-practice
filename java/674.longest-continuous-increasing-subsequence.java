/*
 * @lc app=leetcode.cn id=674 lang=java
 * @lcpr version=30204
 *
 * [674] 最长连续递增序列
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        //dp[i]：第i个元素最大连续递增子序列
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                    dp[i] = Math.max(dp[i - 1] + 1, dp[i]);
            }
            if (dp[i] > result) result = dp[i];
        }
        return result;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,3,5,4,7]\n
// @lcpr case=end

// @lcpr case=start
// [2,2,2,2,2]\n
// @lcpr case=end

 */

