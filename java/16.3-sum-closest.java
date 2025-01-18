/*
 * @lc app=leetcode.cn id=16 lang=java
 * @lcpr version=30204
 *
 * [16] 最接近的三数之和
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Integer min = 100001;
        Integer ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target - sum);
                if (min == 100001) {
                    min = diff;
                    ans = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return sum;
                }
                if (min > diff) {
                    min = diff;
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [-1,2,1,-4]\n1\n
// @lcpr case=end

// @lcpr case=start
// [0,0,0]\n1\n
// @lcpr case=end

 */

