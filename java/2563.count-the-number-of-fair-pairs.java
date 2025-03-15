/*
 * @lc app=leetcode.cn id=2563 lang=java
 * @lcpr version=30204
 *
 * [2563] 统计公平数对的数目
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int start = lowerBound(nums, i + 1, lower - nums[i]);
            int end = lowerBound(nums, i + 1, upper - nums[i] + 1);
            ans += end - start;
        }
        return ans;
    }
    
    private int lowerBound(int[] nums,  int left, int target) {
        int right = nums.length; //[left, right)
        while (left < right) {
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
// [0,1,7,4,4,5]\n3\n6\n
// @lcpr case=end

// @lcpr case=start
// [1,7,9,2,5]\n11\n11\n
// @lcpr case=end

 */

