import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) 
            return null;
        
        Set<Integer> set1 = new HashSet();
        Set<Integer> result = new HashSet();
        
        for (int i1 : nums1) {
            if (set1.contains(i1)) {
                continue;
            }
            set1.add(i1);
        }

        for (int i2 : nums2) {
            if(set1.contains(i2)) {
                result.add(i2);
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }
}
// @lc code=end

