/*
 * @lc app=leetcode.cn id=70 lang=java
 * @lcpr version=30203
 *
 * [70] 爬楼梯
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int climbStairs(int n) {
        //dp[2]有意义
        if(n <= 1) return n; 
        //dp数组初始化
        int[] dp = new int[n + 1];
        //下标含义
        dp[1] = 1;
        dp[2] = 2;
        //递推公式
        //遍历顺序: 从前向后
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
// @lc code=end




/*
// @lcpr case=start
// 2\n
// @lcpr case=end

// @lcpr case=start
// 3\n
// @lcpr case=end

 */

