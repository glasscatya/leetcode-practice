/*
 * @lc app=leetcode.cn id=654 lang=java
 * @lcpr version=30204
 *
 * [654] 最大二叉树
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recurs(nums, 0, nums.length - 1);
    }

    private TreeNode recurs(int[] nums, int start, int end) {
        // 终止条件 
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        // 中 先去找到最大值和其index
        int index = 0;
        int max = 0; // 数组内数字大于零
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        // 左
        if (index > start) {
            root.left = recurs(nums, start, index - 1);
        }
        // 右
        if (index < end) {
            root.right = recurs(nums, index + 1, end);
        }

        return root;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,2,1,6,0,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,2,1]\n
 * // @lcpr case=end
 * 
 */
