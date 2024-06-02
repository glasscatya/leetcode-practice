/*
 * @lc app=leetcode.cn id=704 lang=c
 *
 * [704] 二分查找
 */

// @lc code=start
int search(int* nums, int numsSize, int target) {
    int two = numsSize / 2;
    if(target > nums[two]){
        for(two; two < numsSize; two++) {
            if(target = nums[two]) {
                return two+1;
            }
        }
        return -1;
    } else if (target < nums[two]) {
        for(two; two >= 0; two--) {
            if(target = nums[two]) {
                return two+1;
            }
        }
        return -1;
    } else {
        return -1;
    }
}
// @lc code=end

