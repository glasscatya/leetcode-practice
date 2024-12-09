/*
 * @lc app=leetcode.cn id=617 lang=java
 * @lcpr version=30204
 *
 * [617] 合并二叉树
 */


// @lcpr-template-start
import java.util.*;

import javax.swing.tree.TreeNode;
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return recurs(root1, root2);
    }

    private TreeNode recurs(TreeNode root1, TreeNode root2) {
        // 不能return null 是因为一棵树为空了后 另一棵树可能不为空 后续还可以继续遍历
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        //中
        TreeNode root = new TreeNode();
        root.val = root1.val + root2.val;
        //左
        root.left = recurs(root1.left, root2.left);
        //右
        root.right = recurs(root1.right, root2.right);

        return root;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,3,2,5]\n[2,1,3,null,4,null,7]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n[1,2]\n
// @lcpr case=end

 */

