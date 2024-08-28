/*
 * @lc app=leetcode.cn id=17 lang=java
 * @lcpr version=30204
 *
 * [17] 电话号码的字母组合
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> result = new ArrayList<>();
    private StringBuilder path = new StringBuilder();
    private static final String[] LETTERS = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return result;
        // 回溯
        backtrack(digits, 0);
        return result;
    }

    private void backtrack(String digits, int index) {
        if (path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }
        
        // digits.charAt(index) 获取到的是'1'字符
        // 字符-'0' 就是他俩的ASCII码相减得到的就是字符对应的数字
        // LETTERS[这里面就会是数字]
        String letters = LETTERS[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            path.append(letter);
            backtrack(digits, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "23"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // ""\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "2"\n
 * // @lcpr case=end
 * 
 */
