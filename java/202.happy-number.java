/*
 * @lc app=leetcode.cn id=202 lang=java
 * @lcpr version=30204
 *
 * [202] 快乐数
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        //当n=1时，即找到了目标 而如果record包含了n，说明会无限循环
        while (n != 1 && record.contains(n) == false) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }
    //将本次的n输入 获取本次n的结果
    public Integer getNextNumber(int n) {
        int nextNumber = 0;
        //n>0时说明 n还没有被公式处理完.
        while (n > 0) {
            int temp = n % 10;
            nextNumber += temp * temp;
            n = n / 10;
        }
        return nextNumber;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 19\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 2\n
 * // @lcpr case=end
 * 
 */
