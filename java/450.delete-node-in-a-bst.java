/*
 * @lc app=leetcode.cn id=450 lang=java
 * @lcpr version=30204
 *
 * [450] 删除二叉搜索树中的节点
 */

// @lcpr-template-start
import java.util.*;

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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key); // root.left = 返回出来的节点
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }

        if (root.val == key) {
            if (root.right == null) {
                // 仅有左子节点 或 没有子节点
                return root.left; // 相当于跳过root节点，将root左节点返回出去
            } else if (root.left == null) {
                // 仅有右子节点
                return root.right;
            } else {
                // 同时有左右子节点
                TreeNode cur = root.right; // 重构root的右子树
                while (cur.left != null) {
                    cur = cur.left; // 找到root右子树的最小值 它是root左子树的新根
                }
                cur.left = root.left;
                return root.right;// 返回重构的新子树
            }
        }
        return root;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [5,3,6,2,4,null,7]\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5,3,6,2,4,null,7]\n0\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n0\n
 * // @lcpr case=end
 * 
 */
