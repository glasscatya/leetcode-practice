/*
 * @lc app=leetcode.cn id=153 lang=java
 * @lcpr version=30204
 *
 * [153] 寻找旋转排序数组中的最小值
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[nums.length - 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[left];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,4,5,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [4,5,6,7,0,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [11,13,15,17]\n
// @lcpr case=end

 */

