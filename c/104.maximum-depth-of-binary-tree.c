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
    //终止条件
    if (root == NULL) {
        return 0;
    }
    //Recursive Logic
    //后序遍历 左 右 中  其实最重要的就是关于中的处理 
    //因为一切都是在处理中
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

