/*
 * @lc app=leetcode.cn id=96 lang=java
 * @lcpr version=30204
 *
 * [96] 不同的二叉搜索树
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        //j-1表示root左侧节点,dp[j-1]表示左侧节点有多少种可能的BST。
        //i-j表示root右侧节点,dp[i-j]表示右侧节点有多少种可能的BST
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                //相加= i - 1 = 左侧节点➕右侧节点
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
// @lc code=end



/*
// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

