/*
 * @lc app=leetcode.cn id=1742 lang=java
 * @lcpr version=30204
 *
 * [1742] 盒子中小球的最大数量
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int number = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int num = i;
            while (num > 0) {
                number += num % 10;  // 获取当前最后一位
                num = num / 10;        // 去掉最后一位，移动到下一位
            }
            map.merge(number, 1, Integer::sum);
            max = Math.max(max, map.get(number));
            number = 0;
        }
        return max;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 1\n10\n
// @lcpr case=end

// @lcpr case=start
// 5\n15\n
// @lcpr case=end

// @lcpr case=start
// 19\n28\n
// @lcpr case=end

 */

