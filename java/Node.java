/*
 * @lc app=leetcode.cn id=559 lang=java
 * @lcpr version=30204
 *
 * [559] N 叉树的最大深度
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 0;
        
        for (Node node : root.children) {
            int depth = maxDepth(node); //当前分支的深度
            if (depth > max) max = depth; //所有子分支的最大深度
        }

        return max + 1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,null,3,2,4,null,5,6]\n
// @lcpr case=end

// @lcpr case=start
// [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]\n
// @lcpr case=end

 */

