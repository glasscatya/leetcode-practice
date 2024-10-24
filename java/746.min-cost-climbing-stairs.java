/*
 * @lc app=leetcode.cn id=746 lang=java
 * @lcpr version=30204
 *
 * [746] 使用最小花费爬楼梯
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // dp数组含义：到达当前i层所要的最小花费。
        int[] dp = new int[cost.length + 1];
        // dp数组初始化
        dp[0] = 0;
        dp[1] = 0;

        // 遍历顺序 从前向后
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [10,15,20]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,100,1,1,1,100,1,1,100,1]\n
 * // @lcpr case=end
 * 
 */
