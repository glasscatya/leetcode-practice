/*
 * @lc app=leetcode.cn id=2225 lang=java
 * @lcpr version=30204
 *
 * [2225] 找出输掉零场或一场比赛的玩家
 */

// @lcpr-template-start
import java.util.*;

// @lcpr-template-end
// @lc code=start
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] matche : matches) {
            for (int i = 0; i < 2; i++) {
                int rule = matche[i];
                if (i == 0) {
                    if (!map.containsKey(rule)) {
                        map.put(rule, 0);
                    }
                } else {
                    if (map.containsKey(rule)) {
                        map.put(rule, map.get(rule) + 1);
                    } else {
                        map.put(rule, 1);
                    }
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                zero.add(entry.getKey());
            } else if (entry.getValue() == 1) {
                one.add(entry.getKey());
            }
        }
        
        answer.add(zero);
        answer.add(one);
        return answer;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[2,3],[1,3],[5,4],[6,4]]\n
 * // @lcpr case=end
 * 
 */
