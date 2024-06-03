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
    //暴力解法
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> numCountMap = new HashMap<>();
        
        for (int numb : nums) {
            numCountMap.put(numb, numCountMap.getOrDefault(numb, 0) + 1);
        }

        int maxCount = 0;
        int mostFrequentNum = -1;

        for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentNum = entry.getKey();
            }
        }
        return mostFrequentNum;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [2,2,1,1,1,2,2]\n
// @lcpr case=end

 */

