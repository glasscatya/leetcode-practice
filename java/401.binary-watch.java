/*
 * @lc app=leetcode.cn id=401 lang=java
 * @lcpr version=30204
 *
 * [401] 二进制手表
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    List<String> ans = new ArrayList<>();
    int[] hours = new int[]{1, 2, 4, 8, 0, 0, 0, 0, 0, 0};
    int[] minutes = new int[]{0, 0, 0, 0, 1, 2, 4, 8, 16, 32};
    
    public List<String> readBinaryWatch(int num) {
        backtrack(num, 0, 0, 0);
        return ans;
    }

    public void backtrack(int num, int index, int hour, int minute){
        if(hour > 11 || minute > 59) 
            return;
        if(num == 0){
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(':');
            if (minute < 10) {
                sb.append('0');
            }
            sb.append(minute);
            ans.add(sb.toString());
            return;
        }
        for(int i = index; i < 10; i++){
            backtrack(num - 1, i + 1, hour + hours[i], minute + minutes[i]);
        }  
    }
}
// @lc code=end



/*
// @lcpr case=start
// 1\n
// @lcpr case=end

// @lcpr case=start
// 9\n
// @lcpr case=end

 */

