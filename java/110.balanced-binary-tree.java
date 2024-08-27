/*
 * @lc app=leetcode.cn id=110 lang=java
 * @lcpr version=30204
 *
 * [110] 平衡二叉树
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
    public boolean isBalanced(TreeNode root) {
        // 平衡二叉树：每个节点的子树高度差≤1
        // 因为是更高度相关 使用后序遍历
        return getHight(root) != -1;
    }

    public int getHight(TreeNode root){
        //终止条件        
        if(root == null) return 0;
        //左
        int leftHight = getHight(root.left);
        if(leftHight == -1) return -1; 
        //右
        int rightHight = getHight(root.right);
        if(rightHight == -1) return -1;

        //中
        //左子树与右子树差值＞1 说明不平衡 
        if(Math.abs(leftHight - rightHight) > 1) {
            return -1;
        } 
        //返回当前节点高度
        return Math.max(leftHight, rightHight) + 1;

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,9,20,null,null,15,7]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,2,3,3,null,null,4,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 */
