/*
 * @lc app=leetcode.cn id=225 lang=java
 * @lcpr version=30204
 *
 * [225] 用队列实现栈
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class MyStack {
    private Deque<Integer> deque = new ArrayDeque<>();

    public MyStack() {

    }
    
    public void push(int x) {
        deque.push(x);
    }
    
    public int pop() {
        int i = deque.size();
        while(i > 0) {
            i--;
            deque.push(deque.pollFirst());
        }
        return deque.pop();
    }
    
    public int top() {
        return deque.peekFirst();
    }
    
    public boolean empty() {
        return deque.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end



/*
// @lcpr case=start
// ["MyStack", "push", "push", "top", "pop", "empty"][[], [1], [2], [], [], []]\n
// @lcpr case=end

 */

