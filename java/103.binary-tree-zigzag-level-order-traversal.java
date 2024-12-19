/*
 * @lc app=leetcode.cn id=103 lang=java
 * @lcpr version=30204
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean isLeftToRight = true;
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.offer(root);
        while (queue.size() != 0) {
            List<Integer> vector = new ArrayList<>();
            int size = queue.size();//每一层有几个
            while (size-- != 0) {
                root = queue.removeFirst();
                vector.add(root.val);
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }

            if (isLeftToRight) {
                ans.add(vector);
                isLeftToRight = false;
            } else {
                Collections.reverse(vector);
                ans.add(vector);
                isLeftToRight = true;
            }
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,9,20,null,null,15,7]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

