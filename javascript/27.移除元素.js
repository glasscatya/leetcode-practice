/*
 * @lc app=leetcode.cn id=27 lang=javascript
 *
 * [27] 移除元素
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
 var removeElement = function(nums, val) {
    while(nums.indexOf(val) !== -1){
        nums.splice(nums.indexOf(val),1);
    }
    return nums.length;
};

// @lc code=end

