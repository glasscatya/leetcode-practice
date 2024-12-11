/*
 * @lc app=leetcode.cn id=98 lang=java
 * @lcpr version=30204
 *
 * [98] 验证二叉搜索树
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
    // private int preVal = Integer.MIN_VALUE; 示例中有MIN_VALUE...
    private Integer preVal = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        //中序遍历
        //左
        boolean left = isValidBST(root.left);
        //中
        if (preVal != null && preVal >= root.val) {
            return false;
        }
        preVal = root.val;
        //右
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,1,3]\n
// @lcpr case=end

// @lcpr case=start
// [5,1,4,null,null,3,6]\n
// @lcpr case=end

 */

