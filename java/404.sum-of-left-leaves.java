/*
 * @lc app=leetcode.cn id=404 lang=java
 * @lcpr version=30204
 *
 * [404] 左叶子之和
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
    private int sum = 0;
    private boolean isLeft = false;
    public int sumOfLeftLeaves(TreeNode root) {
        // 前序遍历
        //终止条件 他是左节点 且是 叶子节点
        if(root.left == null && root.right == null && isLeft) {
            sum += root.val;
            return 0;
        }
        //左
        if(root.left != null) {
            isLeft = true;
            sumOfLeftLeaves(root.left);
        }
        //右
        if(root.right != null) {
            isLeft = false;
            sumOfLeftLeaves(root.right);
        }

        return sum;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,9,20,null,null,15,7]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n
 * // @lcpr case=end
 * 
 */
