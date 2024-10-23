/*
 * @lc app=leetcode.cn id=47 lang=java
 * @lcpr version=30204
 *
 * [47] 全排列 II
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start


class Solution {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 同层的上一个元素 如果与当前相同，即continue;
        int[] used = new int[nums.length];
        //先进行排序
        Arrays.sort(nums);
        backTrack(nums, used);
        return result;
    }

    public void backTrack(int[] nums, int[] used) {
        // 收取数据
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        //循环
        for (int i = 0; i < nums.length; i++) {
            //同层去重
            if (i > 0 && used[i - 1] == 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if(used[i] == 1) {
                continue;
            }
            used[i] = 1;
            path.add(nums[i]);
            backTrack(nums, used);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,1,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3]\n
 * // @lcpr case=end
 * 
 */
