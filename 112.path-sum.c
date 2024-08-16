/*
 * @lc app=leetcode.cn id=112 lang=c
 * @lcpr version=30204
 *
 * [112] 路径总和
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
bool hasPathSum(struct TreeNode *root, int targetSum)
{
    // 前序遍历 中左右
    //root为null的情况
    if (root == NULL)
    {
        return false;
    }
    // 中  处理代码+终止条件
    targetSum -= root->val;
    if(root->left == NULL && root->right == NULL) {
        return targetSum == 0;
    }

    return hasPathSum(root->left, targetSum) || hasPathSum(root->right, targetSum);
}
// @lc code=end

/*
// @lcpr case=start
// [5,4,8,11,null,13,4,7,2,null,null,null,1]\n22\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3]\n5\n
// @lcpr case=end

// @lcpr case=start
// []\n0\n
// @lcpr case=end

 */
