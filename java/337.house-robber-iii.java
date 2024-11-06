/*
 * @lc app=leetcode.cn id=337 lang=java
 * @lcpr version=30204
 *
 * [337] 打家劫舍 III
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] dp = robAction(root);
        return Math.max(dp[0], dp[1]);
    }

    private int[] robAction(TreeNode root) {
        int[] dp = new int[2];
        if (root == null) return dp;

        int[] left_dp = robAction(root.left);
        int[] right_dp = robAction(root.right);
        //0 代表不选择当前节点
        dp[0] = Math.max(left_dp[0], left_dp[1]) + Math.max(right_dp[0], right_dp[1]);
        //1 代表选择当前节点
        dp[1] = root.val + left_dp[0] + right_dp[0];

        return dp;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,2,3,null,3,null,1]\n
// @lcpr case=end

// @lcpr case=start
// [3,4,5,1,3,null,1]\n
// @lcpr case=end

 */

