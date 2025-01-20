/*
 * @lc app=leetcode.cn id=2239 lang=java
 * @lcpr version=30204
 *
 * [2239] 找到最接近 0 的数字
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int findClosestNumber(int[] nums) {
        int ans = nums[0];
        int min = Math.abs(ans);
        for (int n : nums) {
            if (Math.abs(n) < Math.abs(min)) {
                min = Math.abs(n);
                ans = n;
            } else if (Math.abs(n) == Math.abs(min) && n > 0) {
                ans = n;
            }
        }
        return min;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [-4,-2,1,4,8]\n
// @lcpr case=end

// @lcpr case=start
// [2,-1,1]\n
// @lcpr case=end

 */

