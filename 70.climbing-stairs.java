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
        int[] memo = new int[n + 1];
        return dfs(n, memo);
    }

    private int dfs(int n, int[] memo) {
        if (n <= 1) {
            return 1;
        }

        if (memo[i] != 0) {
            return memo[i];
        }

        return memo[i] = dfs(n - 1) + dfs(n - 2);
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

