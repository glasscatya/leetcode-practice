/*
 * @lc app=leetcode.cn id=106 lang=java
 * @lcpr version=30204
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lcpr-template-start

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

import java.util.HashMap;
import java.util.Map;

class Solution {
    private int treeVal;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 都为空说明是空
        if (postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return ReceTree(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }

    public TreeNode ReceTree(int[] inorder, int[] postorder, int inorderBegin, int inorderEnd, int postorderBegin,
            int postorderEnd) {
        // 终止条件
        if (postorderBegin == postorderEnd) {
            return null;
        }
        // 将postorder最后一个数放入树中
        treeVal = postorder[postorderEnd - 1];
        TreeNode root = new TreeNode(treeVal);

        // 开始切割
        // 先切割中序
        int delimiterIndex;
        for (delimiterIndex = inorderBegin; delimiterIndex < inorderEnd; delimiterIndex++) {
            if (inorder[delimiterIndex] == treeVal) {
                break;
            }
        }
        // 中序左边
        int inorderLeftBegin = inorderBegin;
        int inorderLeftEnd = delimiterIndex;
        // 中序右边
        int inorderRightBegin = delimiterIndex + 1;
        int inorderRightEnd = inorderEnd;

        // 再切割后序
        // 后序左边 左闭右闭 [ , )
        int postorderLeftBegin = postorderBegin;
        // 后序左边的终点 = 后序起点 + 中序左边的距离
        int postorderLeftEnd = postorderBegin + (delimiterIndex - inorderBegin);
        // 后序右边
        int postorderRightBegin = postorderLeftEnd;
        int postorderRightEnd = postorderEnd - 1;

        // 递归 左
        root.left = ReceTree(inorder, postorder, inorderLeftBegin, inorderLeftEnd, postorderLeftBegin,
                postorderLeftEnd);
        root.right = ReceTree(inorder, postorder, inorderRightBegin, inorderRightEnd, postorderRightBegin,
                postorderRightEnd);

        return root;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [9,3,15,20,7]\n[9,15,7,20,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-1]\n[-1]\n
 * // @lcpr case=end
 * 
 */
