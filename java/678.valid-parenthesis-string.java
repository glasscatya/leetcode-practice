/*
 * @lc app=leetcode.cn id=678 lang=java
 * @lcpr version=30204
 *
 * [678] 有效的括号字符串
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean checkValidString(String s) {
        /*双栈:
            两个栈分别存放可变和左 遇到右先消除左(因为本题中可变能变成空)
            最终结束后 左栈要小于等于可变栈 且 也要应对 "*(" 的情况
            通过让栈记录index来解决 左栈中左index始终小于可变index
        */
        /*贪心:分别记录左括号与可变括号的数量 
            遍历过程中始终不小于0，遍历完成后等于0
            只便利一遍无法应对 "*(" 的情况 
            通过两次遍历解决 (这样做之后 还免去判断左index与可变index关系 
                            因为如果大于第二次遍历是直接就无法通过)
        */
        Deque<Integer> leftStack = new ArrayDeque<>();
        Deque<Integer> varStack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftStack.push(i);
            } else if (c == '*') {
                varStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!varStack.isEmpty()) {
                    varStack.pop();
                } else return false;
            }
        }

        if (leftStack.size() > varStack.size()) {
            return false;
        }

        while (!leftStack.isEmpty()) {
            int leftIndex = leftStack.pop();
            int varIndex = varStack.pop();
            if (leftIndex > varIndex) return false;
        }

        return true;
    }

    public boolean checkValidString0(String s) {
        /*贪心:记录左括号与右括号的数量 
            遍历过程中始终不小于0，遍历完成后等于0
            只便利一遍无法应对 "*(" 的情况 通过两次遍历解决
        */
        int left = 0; 
        int variable = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == '*') {
                variable++;
            } else {
                if (left > 0) {
                    left--;
                } else if (variable > 0) {
                    variable--;
                } else return false;
            }
        }

        left = 0;
        variable = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                left++;
            } else if (c == '*') {
                variable++;
            } else {
                if (left > 0) {
                    left--;
                } else if (variable > 0) {
                    variable--;
                } else return false;
            }
        }
        return true;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "()"\n
// @lcpr case=end

// @lcpr case=start
// "(*)"\n
// @lcpr case=end

// @lcpr case=start
// "(*))"\n
// @lcpr case=end

 */

