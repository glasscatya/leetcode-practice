/*
 * @lc app=leetcode.cn id=538 lang=java
 * @lcpr version=30204
 *
 * [538] 把二叉搜索树转换为累加树
 */


// @lcpr-template-start
import java.util.*;
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
    // 先用双指针实现下
    private TreeNode pre;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        //右
        convertBST(root.right);
        //中
        if (pre != null) root.val += pre.val;

        pre = root;
        //左
        convertBST(root.left);
        
        return root;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]\n
// @lcpr case=end

// @lcpr case=start
// [0,null,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,0,2]\n
// @lcpr case=end

// @lcpr case=start
// [3,2,4,1]\n
// @lcpr case=end

 */

