/*
 * @lc app=leetcode.cn id=513 lang=java
 * @lcpr version=30204
 *
 * [513] 找树左下角的值
 */

// @lcpr-template-start

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
    int maxDepth = Integer.MIN_VALUE; // 全局变量 记录最大深度
    int result; // 存放结果
    int depth = 0; // 当前深度

    public int findBottomLeftValue(TreeNode root) {
        /*
         * 只要先遍历左 再遍历右
         * 这样可以确保"左"边节点永远先被处理
         * 这里的左时相对的左，当最深的一层没有左节点时，右节点就是最左的节点
         * 第一个得到的最深的节点一定是目标
         */
        //中
        depth++;
        // 终止条件
        if (root.left == null & root.right == null && depth > maxDepth) {
            maxDepth = depth;
            result = root.val;
            return result;
        }

        // 左
        if (root.left != null) {
            findBottomLeftValue(root.left);
            depth--;
        }
        // 右
        if (root.right != null) {
            findBottomLeftValue(root.right);
            depth--;
        }
        return result;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,1,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3,4,null,5,6,null,null,7]\n
 * // @lcpr case=end
 * 
 */
