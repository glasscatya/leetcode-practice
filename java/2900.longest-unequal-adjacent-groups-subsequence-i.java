/*
 * @lc app=leetcode.cn id=2900 lang=java
 * @lcpr version=30204
 *
 * [2900] 最长相邻不相等子序列 I
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
            long target = (success + spells[i] - 1) / spells[i];//向上取整
            if (target > potions[potions.length - 1]) {
                result[i] = 0;
                continue;
            }
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
// ["e","a","b"]\n[0,0,1]\n
// @lcpr case=end

// @lcpr case=start
// ["a","b","c","d"]\n[1,0,1,1]\n
// @lcpr case=end

 */

