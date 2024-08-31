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
    private List<Integer> path = new ArrayList<>();
    private List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        // 前序遍历
        // 终止条件
        if(root == null) return result;
        //中
        path.add(root.val);
        if (root.left == null && root.right == null) {
            result.add(toString(path));
            return result;
        }
        //左
        if (root.left != null) {
            binaryTreePaths(root.left);
            path.remove(path.size() - 1);
        }
        //右
        if (root.right != null) {
            binaryTreePaths(root.right);
            path.remove(path.size() - 1);
        }

        return result;
    }
    // 拼接成目标字符串格式
    public String toString(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        sb.append(path.get(0));
        for (int i = 1; i < path.size(); i++) {
                sb.append("->");
                sb.append(path.get(i));
        }

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
