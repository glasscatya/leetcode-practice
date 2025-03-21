/*
 * @lc app=leetcode.cn id=875 lang=java
 * @lcpr version=30204
 *
 * [875] 爱吃香蕉的珂珂
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (h == piles.length) return piles[piles.length - 1];
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        right = right + 1;
        int left = 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(piles, mid) > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
    //返回当前速度下 总共要吃多少小时？
    private int check(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            sum += (pile + speed - 1) / speed;
        }
        return sum;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,6,7,11]\n8\n
// @lcpr case=end

// @lcpr case=start
// [30,11,23,4,20]\n5\n
// @lcpr case=end

// @lcpr case=start
// [30,11,23,4,20]\n6\n
// @lcpr case=end

 */

