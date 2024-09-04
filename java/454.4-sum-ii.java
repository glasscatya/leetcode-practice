/*
 * @lc app=leetcode.cn id=454 lang=java
 * @lcpr version=30204
 *
 * [454] 四数相加 II
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //将四个数组分两块进行累加 时间复杂度为 O(n²)
        for (int i : nums1) {
            for (int j : nums2) {
                //将i+j放入map中， 因为本题是可重复的，value是i+j出现的次数 
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                //如果从3和4中找到了 0 - i - j，让result加上i+j的重复次数
                result += map.getOrDefault(0 - i - j, 0);
            }
        }

        return result;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2]\n[-2,-1]\n[-1,2]\n[0,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0]\n[0]\n[0]\n[0]\n
 * // @lcpr case=end
 * 
 */
