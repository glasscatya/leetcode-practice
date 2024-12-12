/*
 * @lc app=leetcode.cn id=501 lang=java
 * @lcpr version=30204
 *
 * [501] 二叉搜索树中的众数
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
    private List<Integer> ans = new ArrayList<>();
    private int count = 0;
    private int maxCount = 0;
    private TreeNode pre;

    public int[] findMode(TreeNode root) {
        recurs(root);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private void recurs(TreeNode cur) {
        if (cur == null)
            return;
        // 左
        recurs(cur.left);
        // 中
        // if (pre != null) {
        //     if (pre.val == cur.val)
        //         count++;

        // } else
        //     count = 1;
        if (pre != null && pre.val == cur.val)
            count++;
        else
            count = 1;

        if (count == maxCount) {
            ans.add(cur.val);
        } else if (count > maxCount) {
            ans.clear();
            ans.add(cur.val);
            maxCount = count;
        }
        pre = cur;
        // 右
        recurs(cur.right);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,null,2,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0]\n
 * // @lcpr case=end
 * 
 */
