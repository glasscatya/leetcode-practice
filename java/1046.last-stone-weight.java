/*
 * @lc app=leetcode.cn id=1046 lang=java
 * @lcpr version=30204
 *
 * [1046] 最后一块石头的重量
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1) {
            int head1 = maxHeap.poll();
            int head2 = maxHeap.poll();
            if (head1 != head2) {
                maxHeap.offer(head1 - head2);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,7,4,1,8,1]\n
// @lcpr case=end

 */

