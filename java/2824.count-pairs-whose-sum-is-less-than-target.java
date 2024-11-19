/*
 * @lc app=leetcode.cn id=2824 lang=java
 * @lcpr version=30204
 *
 * [2824] 统计和小于目标的下标对数目
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.List;

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int left = 0;
        int right = nums.size() - 1;
        int result = 0;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum < target) {
                result += right - left;
                left++;
            }
            if (sum >= target)
                right--;
        }
        return result;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [-1,1,2,3,1]\n2\n
// @lcpr case=end

// @lcpr case=start
// [-6,2,5,-2,-7,-1,3]\n-2\n
// @lcpr case=end

 */

