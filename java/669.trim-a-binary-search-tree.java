/*
 * @lc app=leetcode.cn id=669 lang=java
 * @lcpr version=30204
 *
 * [669] 修剪二叉搜索树
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
    // 修改后的版本
    public TreeNode trimBST0(TreeNode root, int low, int high) {
        if (root == null) return null;

        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.right = trimBST(root.right, low, high);
        root.left = trimBST(root.left, low, high);
        return root;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;

        if (root.val < low) {
            root.left = null;
            root.right = trimBST(root.right, low, high);
            return root.right;
        } else if (root.val == low) {
            root.left = null;
            root.right = trimBST(root.right, low, high);
            return root;
        } else if (root.val > high) {
            root.right = null;
            root.left = trimBST(root.left, low, high);
            return root.left;
        } else if (root.val == high) {
            root.right = null;
            root.left = trimBST(root.left, low, high);
            return root;
        } else {
            root.right = trimBST(root.right, low, high);
            root.left = trimBST(root.left, low, high);
        }
        return root;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,0,2]\n1\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,0,4,null,2,null,null,1]\n1\n3\n
 * // @lcpr case=end
 * 
 */
