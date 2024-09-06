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
     Map<Integer, Integer> map;  // 方便根据数值查找位置
     public TreeNode buildTree(int[] inorder, int[] postorder) {
         map = new HashMap<>();
         for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
             map.put(inorder[i], i);
         }
 
         return findNode(inorder,  0, inorder.length, postorder,0, postorder.length);  // 前闭后开
     }
 
     public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
         // 参数里的范围都是前闭后开
         if (inBegin >= inEnd || postBegin >= postEnd) {  // 不满足左闭右开，说明没有元素，返回空树
             return null;
         }
         int rootIndex = map.get(postorder[postEnd - 1]);  // 找到后序遍历的最后一个元素在中序遍历中的位置
         TreeNode root = new TreeNode(inorder[rootIndex]);  // 构造结点
         int lenOfLeft = rootIndex - inBegin;  // 保存中序左子树个数，用来确定后序数列的个数
         if(postEnd == 1) return root;
         root.left = findNode(inorder, inBegin, rootIndex,
                 postorder, postBegin, postBegin + lenOfLeft);
         root.right = findNode(inorder, rootIndex + 1, inEnd,
                 postorder, postBegin + lenOfLeft, postEnd - 1);
 
         return root;
     }
 }
// @lc code=end



/*
// @lcpr case=start
// [9,3,15,20,7]\n[9,15,7,20,3]\n
// @lcpr case=end

// @lcpr case=start
// [-1]\n[-1]\n
// @lcpr case=end

 */

