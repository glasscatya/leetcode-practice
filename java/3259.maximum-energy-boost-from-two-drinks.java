/*
 * @lc app=leetcode.cn id=3259 lang=java
 * @lcpr version=30204
 *
 * [3259] 超级饮料的最大强化能量
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public long maxEnergyBoost0(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        // 0 喝0  1 喝1  2 切换的冷静期
        long[][] dp = new long[n][3];
        dp[0][0] = energyDrinkA[0];
        dp[0][1] = energyDrinkB[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + energyDrinkA[i], dp[i - 1][2] + energyDrinkA[i]);
            dp[i][1] = Math.max(dp[i - 1][1] + energyDrinkB[i], dp[i - 1][2] + energyDrinkB[i]);
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
    //状态压缩   将冷静期放在当天，也就是当天的前一天是另一个状态，当天是冷静期，不喝饮料。
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[][] dp = new long[n][2];
        dp[0][0] = energyDrinkA[0];
        dp[0][1] = energyDrinkB[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + energyDrinkA[i], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][1] + energyDrinkB[i], dp[i - 1][0]);
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,3,1]\n[3,1,1]\n
// @lcpr case=end

// @lcpr case=start
// [4,1,1]\n[1,1,3]\n
// @lcpr case=end

 */

