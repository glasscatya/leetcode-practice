/*
 * @lc app=leetcode.cn id=26 lang=javascript
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
 var twoSum = function(nums, target) {
    const len = nums.length;
    let arr = [];
    for(let i = 0; i < len; i++) {
        let x = target - nums[i];
        if(arr[x] !== undefined){
            
            return [arr[x], i];
        }
        // console.log(i);
        // console.log(nums[i]);
        arr[nums[i]] = i;
        // console.log(arr);
    }
}
   
// @lc code=end

