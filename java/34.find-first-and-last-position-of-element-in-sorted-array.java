/*
 * @lc app=leetcode.cn id=34 lang=java
 * @lcpr version=30204
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length > 0 && nums[0] > target) return new int[] {-1, -1};
        int start = lowerBound(nums, target);
        System.out.println(start);
        if (start == nums.length || nums[start] != target) {
            return new int[] {-1, -1};
        }
        //哪怕nums中不存在刚好等于target+1的数
        //最终也会停在target后面一位
        int end = lowerBound(nums, (target + 1)) - 1;
        return new int[] {start, end};
    }
    //返回第一个target的下标，没有返回nums.length或最接近target的数
    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        //[left, right) left >= right 都说明里面没有元素了
        while (left < right) {
            //防止溢出
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [5,7,7,8,8,10]\n8\n
// @lcpr case=end

// @lcpr case=start
// [5,7,7,8,8,10]\n6\n
// @lcpr case=end

// @lcpr case=start
// []\n0\n
// @lcpr case=end

 */

