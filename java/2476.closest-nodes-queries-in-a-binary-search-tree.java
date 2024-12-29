/*
 * @lc app=leetcode.cn id=2476 lang=java
 * @lcpr version=30204
 *
 * [2476] 二叉搜索树最近节点查询
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
    private List<Integer> arr = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> answer = new ArrayList<>();
        getAsc(root);
        for (Integer num : queries) {
            Integer[] tuple = new Integer[] { -1, -1 };
            // 用二分查找
            int i = Collections.binarySearch(arr, num);
            if (i >= 0) {
                //存在等于
                tuple[0] = arr.get(i);
                tuple[1] = arr.get(i);
            } else {
                int insertionPoint = -i - 1;
                if (insertionPoint > 0) {
                    tuple[0] = arr.get(insertionPoint - 1);
                }
                if (insertionPoint < arr.size()) {
                    tuple[1] = arr.get(insertionPoint);
                }
            }
            answer.add(List.of(tuple[0], tuple[1]));
            // 超时 因为给的二叉搜索树不平衡。。。
            // 小于num的最大值
            // for (int i = arr.size() - 1; i >= 0; i--) {
            // if (num >= arr.get(i)) {
            // tuple[0] = arr.get(i);
            // break;
            // }
            // }
            // 大于num的最小值
            // for (int i = 0; i < arr.size(); i++) {
            // if (num <= arr.get(i)) {
            // tuple[1] = arr.get(i);
            // break;
            // }
            // }
        }

        return answer;
    }

    // 拿到顺序排列的数组
    private void getAsc(TreeNode root) {
        if (root == null)
            return;
        getAsc(root.left);
        arr.add(root.val);
        getAsc(root.right);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [6,2,13,1,4,9,15,null,null,null,null,null,null,14]\n[2,5,16]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [4,null,9]\n[3]\n
 * // @lcpr case=end
 * 
 */
