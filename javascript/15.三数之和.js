/*
 * @lc app=leetcode.cn id=15 lang=javascript
 *
 * [15] 三数之和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
 var threeSum = function(nums) {
    const len = nums.length;
    let key = [];
    nums.sort(function (a, b) {
        return a - b;
      });
    //三个指针去移动
    for(let head = 0; head < len -2; head++) {
        if(head === 0 || nums[head] !== nums[head - 1]) {
            let end = len -1;
            let i = head + 1;
            while(i < end) {
                if(nums[head] + nums[i] +nums[end] === 0) {
                    key.push([nums[head], nums[i], nums[end]]);
                    i++;
                    end--;
                    while(nums[i] === nums[i - 1])i++;
                    while(nums[end] === nums[end + 1])end--; 
                } else if(nums[head] + nums[i] + nums[end] < 0) {
                    i++;
                } else {
                    end--;
                }
            }
        }
    }
    return key;
    
};

// @lc code=end

