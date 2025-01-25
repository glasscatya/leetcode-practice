/*
 * @lc app=leetcode.cn id=128 lang=java
 * @lcpr version=30204
 *
 * [128] 最长连续序列
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        // 把数组转成hash
        Set<Integer> hashSet = new HashSet<>();
        for (int n : nums) {
            hashSet.add(n);
        }
        // 考虑hash中的所有数 
        for (int x : hashSet) {
            //如果hash中有x - 1 说明应该从x - 1 开始
            if (hashSet.contains(x - 1)) continue; 
            int y = x + 1;
            //如果hash中包含x + 1 就说明有连续的
            while (hashSet.contains(y)) {
                y++;
            }
            ans = Math.max(ans, y - x);
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [100,4,200,1,3,2]\n
// @lcpr case=end

// @lcpr case=start
// [0,3,7,2,5,8,4,6,0,1]\n
// @lcpr case=end

 */

