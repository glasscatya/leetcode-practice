/*
 * @lc app=leetcode.cn id=347 lang=java
 * @lcpr version=30204
 *
 * [347] 前 K 个高频元素
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
            Map.Entry.<Integer, Integer>comparingByValue().reversed()
        );
        maxHeap.addAll(map.entrySet());
        //任意顺序 倒序也行
        while (k-- > 0) {
            ans[k] = maxHeap.poll().getKey();
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,1,1,2,2,3]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

 */

