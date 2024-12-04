/*
 * @lc app=leetcode.cn id=376 lang=java
 * @lcpr version=30204
 *
 * [376] 摆动序列
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = 1; //当前i一定作为波谷
            dp[i][1] = 1; //当前i一定作为波峰
            
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) { // 上一个只能是波峰
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                } 
                if (nums[j] < nums[i]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
            }
        }

        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,7,4,9,2,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,17,5,10,13,15,10,5,16,8]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5,6,7,8,9]\n
// @lcpr case=end

 */

