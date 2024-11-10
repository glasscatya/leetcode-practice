/*
 * @lc app=leetcode.cn id=300 lang=java
 * @lcpr version=30204
 *
 * [300] 最长递增子序列
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp[i]:第i个数的最长子序列长度
        int[] dp = new int[nums.length];
        //每一个dp[i]最起码是1
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            if (dp[i] > result) result = dp[i];
        }
        return result;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [10,9,2,5,3,7,101,18]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,1,0,3,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [7,7,7,7,7,7,7]\n
 * // @lcpr case=end
 * 
 */
