/*
 * @lc app=leetcode.cn id=1592 lang=java
 *
 * [1592] 重新排列单词间的空格
 */

// @lc code=start
class Solution {
    public String reorderSpaces(String s) {
        StringBuilder res = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if(c = " ") {
                res.append("%20");
            } else {
                res.append(c);
            }
        }

        return res;
    }
}
// @lc code=end

