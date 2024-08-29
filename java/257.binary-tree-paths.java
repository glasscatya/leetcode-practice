/*
 * @lc app=leetcode.cn id=257 lang=java
 * @lcpr version=30204
 *
 * [257] 二叉树的所有路径
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

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
    private List<String> result = new ArrayList<>();
    private List<Integer> paths = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        backtrack(root, paths);
        return result;
    }

    public void backtrack(TreeNode root, List<Integer> paths) {
        //中
        paths.add(root.val);
        //终止条件
        if (root.left == null && root.right == null) {
            result.add(IntToString(paths));
            return ;
        }
        //回溯，走完当前路径后，利用递归弹出当前路径
        if (root.left != null) {
            backtrack(root.left, paths);
            paths.remove(paths.size() - 1);
        }

        if (root.right != null) {
            backtrack(root.right, paths);
            paths.remove(paths.size() - 1);
        }

    }
    //IntToString方法将paths转换成result所需要的格式
    public String IntToString(List<Integer> paths) {
        StringBuilder sb = new StringBuilder();// StringBuilder用来拼接字符串，速度更快
        for (int i = 0; i < paths.size() - 1; i++) {
            sb.append(paths.get(i)).append("->");
        }
        sb.append(paths.get(paths.size() - 1));// 记录最后一个节点

        return sb.toString();
    }
}
// ["1->2","1->2->5","1->2->5","1->2->5->3","1->2->5->3"]
// ["1->2->5","1->3"]
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,null,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n
 * // @lcpr case=end
 * 
 */
