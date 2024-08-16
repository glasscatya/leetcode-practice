/*
 * @lc app=leetcode.cn id=4 lang=javascript
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    let final = [];
    let i = 0;
    let t = 0;
    
    final = nums1.concat(nums2).sort((a, b) => a - b);

    let length = final.length;
    if(length%2 === 0){
        return (final[length/2] + final[length/2 - 1])/2;  
    }else{
        return final[length/2 - 0.5];
    }
};

findMedianSortedArrays([1,2], [3,4]);
// @lc code=end

