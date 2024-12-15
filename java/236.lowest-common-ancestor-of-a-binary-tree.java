/*
 * @lc app=leetcode.cn id=236 lang=java
 * @lcpr version=30204
 *
 * [236] 二叉树的最近公共祖先
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
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root; // 意味着找到了

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //后序遍历 最后处理 中
        //ps:本题中 p 和 q 均存在于给定的二叉树中。 
        if (left != null && right != null) return root;// 左右都找到了想要的
        if (left != null && right == null) { // 左找到了想要的 返回出去
            return left;
        } else if (left == null && right != null) {
            return right; // 右找到了想要的 返回出去
        }
        return null; // 直到最后没能找到p q
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,5,1,6,2,0,8,null,null,7,4]\n5\n1\n
// @lcpr case=end

// @lcpr case=start
// [3,5,1,6,2,0,8,null,null,7,4]\n5\n4\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n1\n2\n
// @lcpr case=end

 */

