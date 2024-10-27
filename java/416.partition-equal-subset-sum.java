/*
 * @lc app=leetcode.cn id=416 lang=java
 * @lcpr version=30204
 *
 * [416] 分割等和子集
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) 
            return false;
        
        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for(int i = 0; i < n; i++) {
            for(int j = target; j >= nums[i]; j--) {
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            if(dp[target] == target)
                return true;
        }
        return dp[target] == target;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,5,11,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3,5]\n
 * // @lcpr case=end
 * 
 */
