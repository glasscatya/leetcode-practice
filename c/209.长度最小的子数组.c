#include <limits.h>
/*
 * @lc app=leetcode.cn id=209 lang=c
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
// int minSubArrayLen(int target, int* nums, int numsSize) {
//     int minLen = INT_MAX;
//     int cur = 0;
//     int sums = 0;
//     int start = 0;
//     for(cur; cur < numsSize; cur++) {
//         sums += nums[cur];
//         while(sums >= target) {
//             minLen = fmin(minLen, cur - start + 1);
//             sums -= nums[cur];
//             start++;
//         }
//     }

//     return minLen == INT_MAX ? 0 : minLen;
// }

int minSubArrayLen(int target, int* nums, int numsSize){
    //初始化最小长度为INT_MAX
    int minLength = INT_MAX;
    int sum = 0;

    int left = 0, right = 0;
    //右边界向右扩展
    for(; right < numsSize; ++right) {
        sum += nums[right];
        //当sum的值大于等于target时，保存长度，并且收缩左边界
        while(sum >= target) {
            int subLength = right - left + 1;
            minLength = fmin(subLength, minLength);
            sum -= nums[left++];
        }
    }
    //若minLength不为INT_MAX，则返回minLnegth
    return minLength == INT_MAX ? 0 : minLength;
}
// @lc code=end

