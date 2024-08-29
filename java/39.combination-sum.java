/*
 * @lc app=leetcode.cn id=39 lang=java
 * @lcpr version=30204
 *
 * [39] 组合总和
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
import java.util.List;
import java.util.ArrayList;

class Solution {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // 先进行排序
        backtarck(candidates, target, 0, 0);
        return result;
    }

    public void backtarck(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) return;
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; (i < candidates.length) && (sum + candidates[i] <= target); i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtarck(candidates, target, sum, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,3,6,7]\n7\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,3,5]\n8\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2]\n1\n
 * // @lcpr case=end
 * 
 */
