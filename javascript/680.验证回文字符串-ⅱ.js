/*
 * @lc app=leetcode.cn id=680 lang=javascript
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */
 var validPalindrome = function(s) {
    let left = 0;
    let right = s.length - 1;
    function isValid(left,right) {
        while(left < right) {
            if(s[left] !== s[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    while(left < right) {
        if(s[left] !== s[right]) {
            return isValid(left+1,right) || isValid(left,right-1);
        }
        left++;
        right--;
    }
    return true;
}
 
// @lc code=end
