/*
 * @lc app=leetcode.cn id=3258 lang=java
 * @lcpr version=30204
 *
 * [3258] 统计满足 K 约束的子字符串数量 I
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        // 滑动窗口
        int ans = 0;
        int zeros = 0;
        int ones = 0;
        int left = 0;
        int right = 0;
        int length = s.length();
        while (right < length) {
            if (s.charAt(right) == '1') {
                ones++;
            } else {
                zeros++;
            } 
            
            while (zeros > k && ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                } else {
                    zeros--;
                }
                left++;
            }
            ans += right - left + 1;
            right++;
        }

        return ans;
    }

    int result = 0;

    public int countKConstraintSubstrings0(String s, int k) {
        // 暴力枚举
        for (int i = 0; i < s.length(); i++) {
            countSubstrings(s, k, i);
        }
        return result;
    }

    private void countSubstrings(String s, int k, int start) {
        int ones = 0;
        int zeros = 0;

        // 从start开始向后扩展子串
        for (int i = start; i < s.length(); i++) {
            // 统计当前子串中的0和1的个数
            if (s.charAt(i) == '1') {
                ones++;
            } else {
                zeros++;
            }

            // 检查是否满足k约束
            if (ones <= k || zeros <= k) {
                result++;
            }
            // 提起退出
            if (ones > k && zeros > k) {
                break;
            }
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "10101"\n1\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "1010101"\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "11111"\n1\n
 * // @lcpr case=end
 * 
 */
