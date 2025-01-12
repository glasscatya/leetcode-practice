/*
 * @lc app=leetcode.cn id=2958 lang=java
 * @lcpr version=30204
 *
 * [2958] 最多 K 个重复元素的最长子数组
 */

// @lcpr-template-start
import java.util.*;

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0;
        int goodArrLen = 0;
        int ans = 0;

        Map<Integer, Integer> count = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            count.merge(nums[right], 1, Integer::sum);
            goodArrLen++;
            while (count.get(nums[right]) > k) {
                count.merge(nums[left], -1, Integer::sum);
                left++;
                goodArrLen--;
            }
            ans = Math.max(ans, goodArrLen);
        }

        return ans;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,1,2,3,1,2]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,1,2,1,2,1,2]\n1\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5,5,5,5,5,5,5]\n4\n
 * // @lcpr case=end
 * 
 */
