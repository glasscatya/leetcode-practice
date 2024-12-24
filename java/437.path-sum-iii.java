/*
 * @lc app=leetcode.cn id=437 lang=java
 * @lcpr version=30204
 *
 * [437] 路径总和 III
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
    private int ans = 0;
    private Long count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return ans;
        //正常的遍历一棵树 然后每个节点都tracking一次
        //中
        count = 0;
        tracking(root, targetSum);
        //左
        if (root.left != null)
            pathSum(root.left, targetSum);
        //右
        if (root.right != null)
            pathSum(root.right, targetSum);

        return ans;
    }

    private void tracking(TreeNode root, int targetSum) {
        if (root == null) return;

        //中
        count += root.val;

        if (count == targetSum) {
            ans++; // 符合的路径➕1
        }

        //左
        if (root.left != null) {
            tracking(root.left, targetSum);
            count -= root.left.val;
        }

        //右
        if (root.right != null) {
            tracking(root.right, targetSum);
            count -= root.right.val;
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [10,5,-3,3,2,null,11,3,-2,null,1]\n8\n
// @lcpr case=end

// @lcpr case=start
// [5,4,8,11,null,13,4,7,2,null,null,5,1]\n22\n
// @lcpr case=end

 */

