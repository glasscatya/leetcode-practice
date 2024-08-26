/*
 * @lc app=leetcode.cn id=222 lang=java
 * @lcpr version=30204
 *
 * [222] 完全二叉树的节点个数
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
class Solution {
    private int sum = 0;
    public int countNodes(TreeNode root) {
        //前序遍历 维护一个sum 每到一个节点 sum++ 最后return
        // 终止条件 
        if(root != null) sum++;
        //这里的返回值被丢弃了 因为递调用中并没有人去接受他
        if(root == null) return 0;
        countNodes(root.left);

        countNodes(root.right);

        return sum;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5,6]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

