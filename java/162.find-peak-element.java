/*
 * @lc app=leetcode.cn id=162 lang=java
 * @lcpr version=30204
 *
 * [162] 寻找峰值
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;//一定是峰顶左侧
        int right = nums.length - 1; //要么是峰顶 要么在峰顶右侧
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid;
            } else {
                right = mid + 1;
            }
        }
        return right;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,1,3,5,6,4]\n
// @lcpr case=end

 */

