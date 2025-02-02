/*
 * @lc app=leetcode.cn id=145 lang=java
 * @lcpr version=30204
 *
 * [145] 二叉树的后序遍历
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
    //反转小改动前序
    public List<Integer> postorderTraversal_0(TreeNode root) {
        var ans = new ArrayList<Integer>();
        if (root == null) return ans;
        var stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            ans.add(root.val);
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }
        Collections.reverse(ans);
        return ans;
    }
    //统一迭代法
    public List<Integer> postorderTraversal(TreeNode root) {
        var ans = new ArrayList<Integer>();
        if (root == null) return ans;
        var stack = new LinkedList<TreeNode>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            //查看栈顶元素
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop();//移除栈顶 我们手上已经有了
                stack.push(node); //中入栈 先入后出
                stack.push(null); //null入栈 标志当前中只查看未处理
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            } else {
                //遇见null
                stack.pop();//移除null
                node = stack.pop();//取出真正要处理的数
                ans.add(node.val);
            }
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,null,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5,null,8,null,null,6,7,9]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

