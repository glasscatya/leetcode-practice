/*
 * @lc app=leetcode.cn id=27 lang=java
 * @lcpr version=30204
 *
 * [27] 移除元素
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) 
                nums[slow++] = nums[fast];
        }
        return slow;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,2,2,3]\n3\n
// @lcpr case=end

// @lcpr case=start
// [0,1,2,2,3,0,4,2]\n2\n
// @lcpr case=end

 */

