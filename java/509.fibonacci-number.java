/*
 * @lc app=leetcode.cn id=509 lang=java
 * @lcpr version=30204
 *
 * [509] 斐波那契数
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
import java.util.stream.Stream;

class Solution {
    public int fib(int n) {
        return Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] })
                .skip(n)
                .findFirst()
                .get()[0];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 4\n
 * // @lcpr case=end
 * 
 */
