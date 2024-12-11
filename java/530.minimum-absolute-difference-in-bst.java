/*
 * @lc app=leetcode.cn id=530 lang=java
 * @lcpr version=30204
 *
 * [530] 二叉搜索树的最小绝对差
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
        private Integer min = Integer.MAX_VALUE;
        private TreeNode pre;
        public int getMinimumDifference(TreeNode root) {
            getMini(root);
            return min;
        }

        public void getMini(TreeNode root) {
            if (root == null) return;
            getMini(root.left);
            if (pre != null && root.val - pre.val< min) {
                min = root.val - pre.val;
            } 
            pre = root;
            getMini(root.right);
        }
    }
// @lc code=end



/*
// @lcpr case=start
// [4,2,6,1,3]\n
// @lcpr case=end

// @lcpr case=start
// [1,0,48,null,null,12,49]\n
// @lcpr case=end

 */

