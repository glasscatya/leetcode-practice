/*
 * @lc app=leetcode.cn id=2116 lang=java
 * @lcpr version=30204
 *
 * [2116] 判断一个括号字符串是否有效
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean canBeValid(String s, String locked) {
        //奇数直接false
        if (s.length() % 2 == 1) return false;
        Deque<Integer> leftStack = new ArrayDeque<>();
        Deque<Integer> unlockedStack = new ArrayDeque<>();
        //思路是：遇到可变放入可变栈，遇到左放入左栈，遇到右从左/可变取一个，没有则false
        for (int i = 0; i < locked.length(); i++) {
            if (locked.charAt(i) == '0') {
                unlockedStack.push(i);
            } else if (s.charAt(i) == '(') {
                leftStack.push(i); //只存储下标 因为最后要比较 是否存在 ‘) (’ 的情况
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!unlockedStack.isEmpty()) {
                    unlockedStack.pop();
                } else {
                    return false;
                }
            }
            
        }
        //上述过程已经消除了所有右 留下左和可变 左数量如果大于可变 返回false
        if (leftStack.size() > unlockedStack.size()) {
            return false;
        }
        //两者相等时 逐个判断 如果左的inde>可变的index说明是 *( *为可变 这种情况下一定是false
        //剩余的左括号无论是小于还是等于可变括号 下面都成立
        //剩余左栈等于可变栈 只要左始终在可变的右边就行  两两消除 
        //左小于可变时 要额外注意 因为左一定要比可变先出现 也就是leftIndex > unlockedIndex
        while (!leftStack.isEmpty()) {
            int leftIndex = leftStack.pop();
            int unlockedIndex = unlockedStack.pop();
            if (leftIndex > unlockedIndex) return false;
        }

        return true;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "))()))"\n"010100"\n
// @lcpr case=end

// @lcpr case=start
// "()()"\n"0000"\n
// @lcpr case=end

// @lcpr case=start
// ")"\n"0"\n
// @lcpr case=end

 */

