/*
 * @lc app=leetcode.cn id=3340 lang=java
 *
 * [3340] 检查平衡字符串
 */

// @lc code=start
class Solution {
    public boolean isBalanced(String num) {
        boolean isOdd = false;
        int odd = 0;
        int even = 0;
        for(char n : num.toCharArray()) {
            if (isOdd) {
                odd += n - '0';
                isOdd = false;
            } else {
                even += n - '0';
                isOdd = true;
            }
        }

        return odd - even == 0;
    }
}
// @lc code=end

