/*
 * @lc app=leetcode.cn id=275 lang=java
 * @lcpr version=30204
 *
 * [275] H 指数 II
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        //找到一个数组中第一个满足nums[i] >= L - i 的i;
        int L = citations.length;
        int left = 0;
        int right = L;
        int ans = 0;
        // [left, right)
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= L - mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        ans = L - left;
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [0,1,3,5,6]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,100]\n
// @lcpr case=end

 */

