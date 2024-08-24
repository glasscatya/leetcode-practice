/*
 * @lc app=leetcode.cn id=216 lang=java
 * @lcpr version=30204
 *
 * [216] 组合总和 III
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int startIndex = 1;
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, startIndex);
        return result;
    }

    private void backtrack(int k, int n, int startIndex) {

        for (int i = startIndex; i <= 10; i++) {
            if (path.size() == k) {
                if (path.stream().mapToInt(Integer::intValue).sum() == n) {
                    result.add(new ArrayList<>(path));
                }
                return;
            }
            path.add(i);
            backtrack(k, n, i+1);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 3\n7\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 3\n9\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 4\n1\n
 * // @lcpr case=end
 * 
 */
