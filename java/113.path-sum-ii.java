/*
 * @lc app=leetcode.cn id=113 lang=java
 * @lcpr version=30204
 *
 * [113] 路径总和 II
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
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return ans;
        //中
        path.add(root.val);

        if (root.left == null && root.right == null && targetSum == 0) {
            ans.add(new ArrayList<>(path));
        }
        //左
        if (root.left != null) {
            pathSum(root.left, targetSum - root.val);
            path.remove(path.size() - 1);
        }
        //右
        if (root.right != null) {
            pathSum(root.right, targetSum - root.val);
            path.remove(path.size() - 1);
        }

        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [5,4,8,11,null,13,4,7,2,null,null,5,1]\n22\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3]\n5\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n0\n
// @lcpr case=end

 */

