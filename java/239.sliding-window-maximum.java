/*
 * @lc app=leetcode.cn id=239 lang=java
 * @lcpr version=30204
 *
 * [239] 滑动窗口最大值
 */


// @lcpr-template-start
import java.util.*;

import Solution.QueueWithMaxElementAtFront;
// @lcpr-template-end
// @lc code=start
class Solution {
    class QueueWithMaxElementAtFront {
        private Deque<Integer> deque = new LinkedList<>();
        //移除元素 (实际上只移除最大元素)
        public void poll(int val) {
            if (!deque.isEmpty() && val == peek()) {
                deque.poll();
            }
        }
        //添加元素 且保证最大值始终在队头
        public void add(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }

        public int peek() {
            return deque.peek();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        var myQueue = new QueueWithMaxElementAtFront();
        int[] ans = new int[nums.length - k + 1];
        if (nums.length == 1) return nums;
        int index = 0;
        //将myQueue初始化
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        ans[index++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i - k]);
            myQueue.add(nums[i]);
            ans[index++] = myQueue.peek(); 
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,3,-1,-3,5,3,6,7]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

 */

