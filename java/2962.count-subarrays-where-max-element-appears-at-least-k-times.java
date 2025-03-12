/*
 * @lc app=leetcode.cn id=2962 lang=java
 * @lcpr version=30204
 *
 * [2962] 统计最大元素出现至少 K 次的子数组
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxValue = 0;
        for (int n : nums) {
            maxValue = Math.max(maxValue, n);
        }
        int left =0;
        long ans = 0;
        int cntMax = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == maxValue) cntMax++;
            //当cntMax刚好等于k个时，我们移动left窗口到刚好等于k-1个
            //这样我们窗口内有k-1个maxValue，窗口左边最后一个就是maxValue
            //可以直接计算出 满足k个maxValue时有几种子连续数组 (就是left个)
            /*         l r   maxvalue = 3，k = 2 
             * 1 2 9 3 2 3   这时候，l前面一定有一个3 窗口内一定有一个3
             *               1 2 9 3在至少包含一个3的情况下总共4中子数组
             */
            while (cntMax == k) {
                if (nums[left] == maxValue) cntMax--;
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,3,2,3,3]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,4,2,1]\n3\n
// @lcpr case=end

 */

