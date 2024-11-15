/*
 * @lc app=leetcode.cn id=718 lang=java
 * @lcpr version=30204
 *
 * [718] 最长重复子数组
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int findLength0(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int result = 0;
        //i从1开始  [i][0]全部都是0 可以免去要额外判断 i - 1 < 0的情况
        //具体情况可以动手画个二维矩阵可以更清晰
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                //nums元素下标和位置刚好相差 1
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > result) result = dp[i][j];
            }
        }
        return result;
    }
    //滚动数组 
    public int findLength(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];
        int result = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = nums2.length; j > 0; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                    if (dp[j] > result) result = dp[j];
                } else {
                    dp[j] = 0;
                }
            }
        }
        return result;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,2,1]\n[3,2,1,4,7]\n
// @lcpr case=end

// @lcpr case=start
// [0,0,0,0,0]\n[0,0,0,0,0]\n
// @lcpr case=end

 */

