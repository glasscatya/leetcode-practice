/*
 * @lc app=leetcode.cn id=11 lang=java
 * @lcpr version=30204
 *
 * [11] 盛最多水的容器
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = (right - left) * Math.min(height[left], height[right]);
        while (left < right) {
            if (height[left] <= height[right]) {
                left++;
                max = Math.min((right - left) * Math.min(height[left], height[right]), max);
            } else {
                right--;
                max = Math.min((right - left) * Math.min(height[left], height[right]), max);
            }
        }
        return max;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,8,6,2,5,4,8,3,7]\n
// @lcpr case=end

// @lcpr case=start
// [1,1]\n
// @lcpr case=end

 */

