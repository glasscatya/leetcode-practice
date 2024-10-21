/*
 * @lc app=leetcode.cn id=491 lang=java
 * @lcpr version=30204
 *
 * [491] 非递减子序列
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.*;

class Solution {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTrack(nums, 0);
        return result;
    }

    void backTrack(int[] nums, int curr) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        Set<Integer> hSet = new HashSet<>();
        // 回溯
        for (int i = curr; i < nums.length; i++) {
            if (!path.isEmpty() && (nums[i] < path.get(path.size() - 1))
                    || hSet.contains(nums[i])) {
                continue;
            }
            hSet.add(nums[i]);
            path.add(nums[i]);
            backTrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [4,6,7,7]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [4,4,3,2,1]\n
 * // @lcpr case=end
 * 
 */
