/*
 * @lc app=leetcode.cn id=169 lang=java
 * @lcpr version=30203
 *
 * [169] 多数元素
 */

// @lcpr-template-start

// @lcpr-template-end 
// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        // 方法1.计数法 遍历数组，后计数。
        // HashMap<Integer, Integer> numCountMap = new HashMap<>();

        // for (int numb : nums) {
        // numCountMap.put(numb, numCountMap.getOrDefault(numb, 0) + 1);
        // }

        // int maxCount = 0;
        // int mostFrequentNum = -1;

        // for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
        // if (entry.getValue() > maxCount) {
        // maxCount = entry.getValue();
        // mostFrequentNum = entry.getKey();
        // }
        // }
        // return mostFrequentNum;

        // 方法2.摩尔投票法。

        int count = 1;
        int cand_num = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            if (cand_num == nums[i + 1]) {
                count++;
            } else {
                count--;
            }
            
            if (count == 0) {
                cand_num = nums[i + 1];
                count = 1;
            }
        }

        return cand_num;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,2,1,1,1,2,2]\n
 * // @lcpr case=end
 * 
 */
