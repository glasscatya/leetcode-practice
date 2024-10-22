/*
 * @lc app=leetcode.cn id=46 lang=java
 * @lcpr version=30204
 *
 * [46] 全排列
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
import java.util.*;

class Solution {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length];
        backTrack(nums, used);
        return result;
    }
    //使用数组
    public void backTrack(int[] nums, int[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 暴力 每次都循环到底 然后用set判断当前值是否存过。。。
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            backTrack(nums, used);
            path.remove(path.size() - 1);
        }
    }

    //使用set
    private Set<Integer> set = new HashSet<>();
    public void backTrack_Set(int[] nums) {
        //收取条件
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 暴力 每次都循环到底 然后用set判断当前值是否存过。。。
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            set.add(nums[i])
            backTrack(nums);
            path.remove(path.size() - 1);
            set.remove(nums[i]);
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n
 * // @lcpr case=end
 * 
 */
