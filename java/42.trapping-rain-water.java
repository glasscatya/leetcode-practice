/*
 * @lc app=leetcode.cn id=42 lang=java
 * @lcpr version=30204
 *
 * [42] 接雨水
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int trap(int[] height) {
        /**
         * 时间复杂度：O(n) 
         * 空间复杂度：O(n)
         */
        int[] pre = new int[height.length];
        int[] suf = new int[height.length];
        pre[0] = height[0];
        suf[suf.length - 1] = height[height.length - 1];
        int count = 0;
        for (int i = 1; i < height.length; i++) {
            pre[i] = Math.max(pre[i - 1], height[i]);//前缀最高
        }
        for (int i = height.length - 2; i >= 0; i--) {
            suf[i] = Math.max(suf[i + 1], height[i]);//后缀最高
        }
        //求每一格能放的水 也就是：min(左高,右高) - 当前格height
        for (int i = 0; i < height.length; i++) {
            count += Math.min(pre[i], suf[i]) - height[i];
        }
        return count;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [0,1,0,2,1,0,1,3,2,1,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [4,2,0,3,2,5]\n
// @lcpr case=end

 */

