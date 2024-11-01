/*
 * @lc app=leetcode.cn id=377 lang=java
 * @lcpr version=30204
 *
 * [377] 组合总和 Ⅳ
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int combinationSum4(int[] nums, int target) {
        //爬梯子plus
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i >= n)
                    dp[i] += dp[i - n];
            }
        }

        return dp[target];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3]\n4\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [9]\n3\n
 * // @lcpr case=end
 * 
 */
