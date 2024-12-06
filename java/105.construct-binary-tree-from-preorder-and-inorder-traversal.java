/*
 * @lc app=leetcode.cn id=105 lang=java
 * @lcpr version=30204
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursiveBuild(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    private TreeNode recursiveBuild(int[] preorder, int[] inorder, int preorderBegin, int preorderEnd,
            int inorderBegin, int inorderEnd) {
        if (preorderBegin == preorderEnd) { // 前序数组遍历完全
            return null;
        }
        int rootVal = preorder[preorderBegin];
        int breakPoint = map.get(rootVal); // 改成使用map，这样可以省下每次定位breakPoint所要的循环
        // 遍历中序数组 找到root节点在中序数组的位置
        // for (breakPoint = inorderBegin; breakPoint < inorderEnd; breakPoint++) {
        //     if (inorder[breakPoint] == rootVal) {
        //         break;
        //     }
        // }


        // 左闭右开
        int inorderLeftBegin = inorderBegin;
        int inorderLeftEnd = breakPoint;
        int inorderRightBegin = breakPoint + 1;
        int inorderRightEnd = inorderEnd;
        // 左开右闭
        int preorderLeftBegin = preorderBegin + 1;
        int preorderLeftEnd = preorderLeftBegin + inorderLeftEnd - inorderLeftBegin;
        int preorderRightBegin = preorderLeftEnd;
        int preorderRightEnd = preorderEnd;

        TreeNode root = new TreeNode(rootVal);
        root.left = recursiveBuild(preorder, inorder, preorderLeftBegin, preorderLeftEnd, inorderLeftBegin, inorderLeftEnd);
        root.right = recursiveBuild(preorder, inorder, preorderRightBegin, preorderRightEnd, inorderRightBegin, inorderRightEnd);
        
        return root;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,9,20,15,7]\n[9,3,15,20,7]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-1]\n[-1]\n
 * // @lcpr case=end
 * 
 */
