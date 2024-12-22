/*
 * @lc app=leetcode.cn id=129 lang=java
 * @lcpr version=30204
 *
 * [129] 求根节点到叶节点数字之和
 */


// @lcpr-template-start
import java.util.*;

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
    private int ans;
    private List<Integer> path = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        //叶子节点
        path.add(root.val);
        if (root.left == null && root.right == null) {
            ans += getNum(path);
        }
        //左 + 回溯
        if (root.left != null) {
            sumNumbers(root.left);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            sumNumbers(root.right);
            path.remove(path.size() - 1);
        }
        return ans;
    }

    private int getNum(List<Integer> path) {
        int target = 0;
        for (Integer integer : path) {
            target = target * 10 + integer;
        }
        return target;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [4,9,0,5,1]\n
// @lcpr case=end

 */

