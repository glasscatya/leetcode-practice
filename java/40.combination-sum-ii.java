/*
 * @lc app=leetcode.cn id=40 lang=java
 * @lcpr version=30204
 *
 * [40] 组合总和 II
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();
    private int sum = 0;
    private boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 先排序，方便去重
        Arrays.sort(candidates);
        // 初始化used
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        // 开始
        backtrack(candidates, target, 0);
        return result;
    }

    public void backtrack(int[] candidates, int target, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            //剪枝  这题不剪枝,leetcode直接超时hhh
            if(sum + candidates[i] > target) return ;
            /* 最难理解的是used如何实现去重的 这个used用于判断你是在递归中 还是在回溯中
             * 例如 [1,1,1,4] target=6 如果不去重显然会出现  [1,1,4] x3(拿笔画下是简单的排列组合
             * 而我们要的答案只有[1,1,4] 使用used可以做到这一点
             * 当回溯for第一次开始时，startIndex=0，if (i > 0)为false。
             * 1.而选择了第一个1，used[0] = true，接下来我们就可以正常的选择剩余的1，因为used[i-1] == false是false
             *   这样就实现了，我们可以重复选取多个1（因为他们是不同元素，只是恰好值相同）
             *   等回溯for的第一次循环结束时，因为回溯的特性used再次全为false。
             * 2、回溯for第二次开始时，[1,1,1,4]，触发了if中的跳过，然后i正常++,
             *   第二次回溯i=1时，再次跳过....这样就保证了只有第一次出现的值才被完整递归，
             *   而重复出现的所有值都被跳过。
             * (这也很好想，因为回溯的特性，第一次出现的值就已经包含了所有情况。）
             * （例如 [1,1,1,4] 1的第一次出现，就已经包含了1->1->4）
             * 这样就完成了去重。
             * 
            */
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                continue;
            }
            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, target, i + 1);
            sum -= candidates[i];
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [10,1,2,7,6,1,5]\n8\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,5,2,1,2]\n5\n
 * // @lcpr case=end
 * 
 */
