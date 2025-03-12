/*
 * @lc app=leetcode.cn id=1004 lang=java
 * @lcpr version=30204
 *
 * [1004] 最大连续1的个数 III
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        //只需要记录出现0的数量 与 k的关系
        int left = 0;
        int cnt0 = 0;
        int max = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) cnt0++;
            while (cnt0 > k) {
                if (nums[left] == 0) cnt0--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,1,1,0,0,0,1,1,1,1,0]\n2\n
// @lcpr case=end

// @lcpr case=start
// [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]\n3\n
// @lcpr case=end

 */

