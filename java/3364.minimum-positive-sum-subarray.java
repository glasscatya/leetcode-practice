/*
 * @lc app=leetcode.cn id=3364 lang=java
 * @lcpr version=30204
 *
 * [3364] 最小正和子数组
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minSum = Integer.MAX_VALUE;
        int n = nums.size();

        // 遍历所有可能的子数组长度
        for (int len = l; len <= r; len++) {
            int windowSum = 0;

            // 初始化第一个窗口的和
            for (int i = 0; i < len; i++) {
                windowSum += nums.get(i);
            }

            // 检查第一个窗口
            if (windowSum > 0 && windowSum < minSum) {
                minSum = windowSum;
            }

            // 滑动窗口
            for (int i = len; i < n; i++) {
                windowSum += nums.get(i) - nums.get(i - len);
                if (windowSum > 0 && windowSum < minSum) {
                    minSum = windowSum;
                }
            }
        }

        // 如果没有找到满足条件的子数组，返回 -1
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3, -2, 1, 4]\n2\n3\n
// @lcpr case=end

// @lcpr case=start
// [-2, 2, -3, 1]\n2\n3\n
// @lcpr case=end

// @lcpr case=start
// [1, 2, 3, 4]\n2\n4\n
// @lcpr case=end

 */

