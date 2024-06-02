/*
 * @lc app=leetcode.cn id=844 lang=javascript
 *
 * [844] 比较含退格的字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
 var backspaceCompare = function(s, t) {
    let sarr = [];
    let tarr = [];
    let count = 0;
    while(count < s.length) {
        if(s[count] !== "#"){
            sarr.push(s[count]);
        } else {
            sarr.pop();
        }
        count++;
    }
    count = 0;
    while(count < t.length) {
        if(t[count] !== "#"){
            tarr.push(t[count]);
        } else {
            tarr.pop();
        }
        count++;
    }
    if(sarr.length === tarr.length){
        count = 0;
        while(count < sarr.length) {
            if(sarr[count] !== tarr[count]) {
                return 0;
            }
            count++;
        }
        return 1;
    } else {
        return 0;
    }
};
// @lc code=end

