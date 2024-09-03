/*
 * @lc app=leetcode.cn id=112 lang=java
 * @lcpr version=30204
 *
 * [112] 路径总和
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSum = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return isSum;
        backtrack(root, targetSum);
        return isSum;
    }

    public void backtrack(TreeNode node, int targetSum) {
        // 中
        targetSum -= node.val;
        // 终止条件
        if (node.left == null && node.right == null) {
            if (targetSum == 0)
                isSum = true;
            return;
        }
        // 左
        if (node.left != null) {
            backtrack(node.left, targetSum);
        }
        // 右
        if (node.right != null) {
            backtrack(node.right, targetSum);
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [5,4,8,11,null,13,4,7,2,null,null,null,1]\n22\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3]\n5\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n0\n
 * // @lcpr case=end
 * 
 */
