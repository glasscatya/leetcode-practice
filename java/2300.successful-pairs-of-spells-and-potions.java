/*
 * @lc app=leetcode.cn id=2300 lang=java
 * @lcpr version=30204
 *
 * [2300] 咒语和药水的成功对数
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            long target = (success + spells[i] + 1) / spells[i];//向上取整
            int start = lowerBound(potions, target);
            
            //前一半判断没找到
            result[i] = potions.length - start;
        }
        return result;
    }
    private int lowerBound(int[] nums, long target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [5,1,3]\n[1,2,3,4,5]\n7\n
// @lcpr case=end

// @lcpr case=start
// [3,1,2]\n[8,5,8]\n16\n
// @lcpr case=end

 */

