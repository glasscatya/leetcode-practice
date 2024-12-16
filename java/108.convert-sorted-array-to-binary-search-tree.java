/*
 * @lc app=leetcode.cn id=108 lang=java
 * @lcpr version=30204
 *
 * [108] 将有序数组转换为二叉搜索树
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return recurs(nums, 0, nums.length);
    }
    //左闭右开
    private TreeNode recurs(int[] nums, int start, int end) {
        if (start == end) return null;

        int rootIndex = start + (end - start) / 2;
        // 根节点
        TreeNode root = new TreeNode(nums[rootIndex]); 
        // 根节点的左右
        root.left = recurs(nums, start, rootIndex);

        root.right = recurs(nums, rootIndex + 1, end);

        return root;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [-10,-3,0,5,9]\n
// @lcpr case=end

// @lcpr case=start
// [1,3]\n
// @lcpr case=end

 */

