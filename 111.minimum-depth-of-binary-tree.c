/*
 * @lc app=leetcode.cn id=111 lang=c
 * @lcpr version=30204
 *
 * [111] 二叉树的最小深度
 */
// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int minDepth(struct TreeNode *root)
{
    if (root == NULL)
        return 0;

    int highLeft = minDepth(root->left);
    int highRight = minDepth(root->right);
    //中 ： 处理逻辑 只有root的左右有一个为空时，需要额外判断 而node左右有一个为空时，刚刚好就是我们想要的结果。
    if (root->left == NULL && root->right != NULL)
    {
        return 1 + highRight;
    }

    if (root->left != NULL && root->right == NULL)
    {
        return 1 + highLeft;
    }

    int high = (highLeft > highRight ? highRight : highLeft) + 1;

    return high;
}
// @lc code=end

/*
// @lcpr case=start
// [3,9,20,null,null,15,7]\n
// @lcpr case=end

// @lcpr case=start
// [2,null,3,null,4,null,5,null,6]\n
// @lcpr case=end

 */
