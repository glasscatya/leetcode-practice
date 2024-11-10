/*
 * @lc app=leetcode.cn id=739 lang=java
 * @lcpr version=30204
 *
 * [739] 每日温度
 */

// @lcpr-template-start
import java.util.*;

// @lcpr-template-end
// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] answer = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0); // 存入数组下标
        for (int i = 1; i < length; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                //因为单调栈查找的是第一个 
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    answer[stack.peek()] = i - stack.pop();
                }
                stack.push(i);
            }
        }
        return answer;
    }
}

// @lc code=end

/*
 * // @lcpr case=start
 * // [73,74,75,71,69,72,76,73]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [30,40,50,60]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [30,60,90]\n
 * // @lcpr case=end
 * 
 */
