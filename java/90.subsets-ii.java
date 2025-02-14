/*
 * @lc app=leetcode.cn id=90 lang=java
 * @lcpr version=30204
 *
 * [90] 子集 II
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        dfs(0, nums, used);
        return ans;
    }
    private void dfs(int startIndex, int[] nums, int[] used) {
        ans.add(new ArrayList<>(path));
        //去重
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && used[i - 1] == 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            dfs(i + 1, nums, used);
            used[i] = 0;
            path.removeLast();
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,2]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */

