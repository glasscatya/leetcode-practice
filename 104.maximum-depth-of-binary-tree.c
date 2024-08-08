/*
 * @lc app=leetcode.cn id=104 lang=c
 * @lcpr version=30204
 *
 * [104] 二叉树的最大深度
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
// struct TreeNode {
//       int val;
//       struct TreeNode *left;
//       struct TreeNode *right;
//  };

int maxDepth(struct TreeNode* root) {
    if (root == NULL) {
        return 0;
    }
    int depthLeft = maxDepth(root->left);
    int depthRight = maxDepth(root->right);

    return (depthLeft > depthRight ? depthLeft : depthRight) + 1;
}
// @lc code=end



/*
// @lcpr case=start
// [3,9,20,null,null,15,7]\n
// @lcpr case=end

// @lcpr case=start
// [1,null,2]\n
// @lcpr case=end

 */

