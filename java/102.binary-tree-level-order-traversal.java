/*
 * @lc app=leetcode.cn id=102 lang=java
 * @lcpr version=30204
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root != null) queue.addLast(root);
        while (queue.size() > 0) {
            List<Integer> vetor = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                root = queue.removeFirst();
                vetor.add(root.val);
                if (root.left != null) {
                    queue.addLast(root.left);
                }
                if (root.right != null) {
                    queue.addLast(root.right);
                }
            }
            result.add(vetor);
        }
        return result;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,9,20,null,null,15,7]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 */
