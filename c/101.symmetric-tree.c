/*
 * @lc app=leetcode.cn id=101 lang=c
 * @lcpr version=30204
 *
 * [101] 对称二叉树
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
bool isSymmetric(struct TreeNode *root)
{
    if (root == NULL){
        return true;
    }
    return isEqu(root->left, root->right);
}

bool isEqu(struct TreeNode *left, struct TreeNode *right)
{
    if (left == NULL || right == NULL)
    {
        return false;
    }
    else if (left->val != right->val)
    {
        return false;
    }
    else
    {
        return isEqu(left->left, right->left) && isEqu(left->right, right->right);
    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,2,2,3,4,4,3]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,2,null,3,null,3]\n
// @lcpr case=end

 */
