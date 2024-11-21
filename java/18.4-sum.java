/*
 * @lc app=leetcode.cn id=18 lang=java
 * @lcpr version=30204
 *
 * [18] 四数之和
 */

// @lcpr-template-start
import java.util.*;

// @lcpr-template-end
// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        for (int a = 0; a < len - 3; a++) {
            long x = nums[a];
            if (a > 0 && x == nums[a - 1]) continue;
            //最小的三个 + 最大的一个 > 目标  ---> 不可能有等于目标的了
            if (x + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) break;
            if (x + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) continue;
            for (int b = a + 1; b < len - 2; b++) {
                long y = nums[b];
                if (b > a + 1 && y == nums[b - 1]) continue;
                if (x + y + nums[b + 1] + nums[b + 2] > target) break; // 优化一
                if (x + y + nums[len - 2] + nums[len - 1] < target) continue; // 优化二
                int c = b + 1; // 从b开始的➕1
                int d = len - 1;
                while (c < d) {
                    long sum = x + y + nums[c] + nums[d];
                    if (sum < target) {
                        c++;
                    } else if (sum > target) {
                        d--;
                    } else {
                        ans.add(List.of((int) x, (int) y, nums[c], nums[d]));
                        for (c++; c < d && nums[c] == nums[c - 1]; c++);
                        for (d--; d > c && nums[d] == nums[d + 1]; d--);
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,0,-1,0,-2,2]\n0\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,2,2,2,2]\n8\n
 * // @lcpr case=end
 * 
 */
