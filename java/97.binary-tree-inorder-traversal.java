/*
 * @lc app=leetcode.cn id=94 lang=java
 * @lcpr version=30204
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        var ans = new ArrayList<Integer>();
        if (root == null) return ans;
        var stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            // root 不为空 当前root放入栈中
            if (root != null) {
                stack.push(root);
                //左
                root = root.left;
            } else {
                //root 为空 从stack中取值
                root = stack.pop();
                //中
                ans.add(root.val);
                //右
                root = root.right;
            }
        }
        return ans;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,null,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n
 * // @lcpr case=end
 * 
 */
