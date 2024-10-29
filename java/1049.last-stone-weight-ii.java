/*
 * @lc app=leetcode.cn id=1049 lang=java
 * @lcpr version=30204
 *
 * [1049] 最后一块石头的重量 II
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones)
            sum += stone;
        int target = sum / 2;
        int[] dp = new int[1501];
        // dp数组初始化为0 Java中数组默认值为0;
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                // 因为一维dp中，所有数据都是在上层dp的基础上得到
                // 而上层dp数据存储在本层中 从后向前遍历 能保证所需要的值都在
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] - dp[target];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,7,4,1,8,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [31,26,33,21,40]\n
 * // @lcpr case=end
 * 
 */
