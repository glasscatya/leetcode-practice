/*
 * @lc app=leetcode.cn id=713 lang=java
 * @lcpr version=30204
 *
 * [713] 乘积小于 K 的子数组
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int product = 1;
        int ans = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left++];
            }
            ans += right - left + 1; //r - l个元素相乘 ＜ target，总共有r - l + 1种组合
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [10,5,2,6]\n100\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3]\n0\n
// @lcpr case=end

 */

