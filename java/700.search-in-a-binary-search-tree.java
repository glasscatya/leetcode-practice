/*
 * @lc app=leetcode.cn id=700 lang=java
 * @lcpr version=30204
 *
 * [700] 二叉搜索树中的搜索
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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root.val == val)
            return root;
        if (val < root.val)
            root = searchBST(root.left, val);
        else if (val > root.val)
            root = searchBST(root.right, val);
        return root;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [4,2,7,1,3]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [4,2,7,1,3]\n5\n
 * // @lcpr case=end
 * 
 */
