/*
 * @lc app=leetcode.cn id=563 lang=java
 * @lcpr version=30204
 *
 * [563] 二叉树的坡度
 */

// @lcpr-template-start
import java.util.*;

import javax.swing.tree.TreeNode;

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
    int count = 0;
    public int findTilt(TreeNode root) {
        find(root);
        return count;
    }

    private int find(TreeNode root) {
        if (root == null) return 0;
        //左
        int left = find(root.left);
        //右
        int right = find(root.right);
        //中
        count += Math.abs(left - right);
        return left + right + root.val;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [4,2,9,3,5,null,7]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [21,7,14,1,1,2,2,3,3]\n
 * // @lcpr case=end
 * 
 */
