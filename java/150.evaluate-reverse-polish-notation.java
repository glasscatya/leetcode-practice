/*
 * @lc app=leetcode.cn id=150 lang=java
 * @lcpr version=30204
 *
 * [150] 逆波兰表达式求值
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        //数字放入栈中，运算法弹出栈顶数字，运算后放回栈中
        var stack = new ArrayDeque<Integer>();
        for (String s : tokens) {
            switch (s) {
                case "+": {
                    int n2 = stack.pop();
                    int n1 = stack.pop();
                    stack.push(n1 + n2);
                    break;
                }
                case "-": {
                    int n2 = stack.pop();
                    int n1 = stack.pop();
                    stack.push(n1 - n2);
                    break;
                }
                case "*": {
                    int n2 = stack.pop();
                    int n1 = stack.pop();
                    stack.push(n1 * n2);
                    break;
                }
                case "/": {
                    int n2 = stack.pop();
                    int n1 = stack.pop();
                    stack.push(n1 / n2);
                    break;
                }
                default: {
                    stack.push(Integer.valueOf(s));
                    break;
                }
            }
        }
        return stack.pop();
    }
}
// @lc code=end



/*
// @lcpr case=start
// ["2","1","+","3","*"]\n
// @lcpr case=end

// @lcpr case=start
// ["4","13","5","/","+"]\n
// @lcpr case=end

// @lcpr case=start
// ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]\n
// @lcpr case=end

 */

