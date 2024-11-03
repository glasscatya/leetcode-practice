/*
 * @lc app=leetcode.cn id=279 lang=java
 * @lcpr version=30204
 *
 * [279] 完全平方数
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;

        for (int j = 1; j <= n; j++) {
            for (int i = 1; (i * i) <= j; i++) {
                //因为完全平方数里面有个1 不会出现无法抵达的楼层！
                // if(dp[j - (i * i)] != Integer.MAX_VALUE)
                dp[j] = Math.min(dp[j], dp[j - (i * i)] + 1);
            }
        }
        return dp[n];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 12\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 13\n
 * // @lcpr case=end
 * 
 */
