/*
 * @lc app=leetcode.cn id=45 lang=java
 * @lcpr version=30204
 *
 * [45] 跳跃游戏 II
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int cover = nums[0];
        int nextCover = 0;
        int ans = 0;
        if (nums.length == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            nextCover = Math.max(nextCover, nums[i] + i);
            if (i == 0) ans++;
            if (i == cover && cover < nums.length - 1) {
                ans++;
                cover = nextCover;
                if (cover >= nums.length - 1) return ans;
            }
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,3,1,1,4]\n
// @lcpr case=end

// @lcpr case=start
// [2,3,0,1,4]\n
// @lcpr case=end

 */

