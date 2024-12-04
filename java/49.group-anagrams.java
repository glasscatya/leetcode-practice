/*
 * @lc app=leetcode.cn id=49 lang=java
 * @lcpr version=30204
 *
 * [49] 字母异位词分组
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            List<String> list = map.computeIfAbsent(new String(s), value -> new ArrayList<>());
            list.add(str); // 排序后的新字符串 s作为key  新建列表作为value 再向value里存入数据。
        }
        return new ArrayList<>(map.values());
    }
}
// @lc code=end



/*
// @lcpr case=start
// ["eat", "tea", "tan", "ate", "nat", "bat"]\n
// @lcpr case=end

// @lcpr case=start
// [""]\n
// @lcpr case=end

// @lcpr case=start
// ["a"]\n
// @lcpr case=end

 */

