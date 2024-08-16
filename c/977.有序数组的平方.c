/*
 * @lc app=leetcode.cn id=977 lang=c
 *
 * [977] 有序数组的平方
 */

// @lc code=start
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

int* sortedSquares(int* nums, int numsSize, int* returnSize) {
    int i = 0;
    int left = 0;
    int right = numsSize-1;
    int newNums[numsSize];
    while(left <= right) {
        if(nums[left]*nums[left] > nums[right]*nums[right]) {
            newNums[i] = nums[left]*nums[left];
            left++;
        } else {
            newNums[i] = nums[right]*nums[right];
            right++;
        }
        i++;
    }
    
    return newNums;
}
// @lc code=end

