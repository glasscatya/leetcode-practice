/*
 * @lc app=leetcode.cn id=912 lang=java
 * @lcpr version=30204
 *
 * [912] 排序数组
 */

// @lcpr-template-start
import java.util.*;

// @lcpr-template-end
// @lc code=start
class Solution {
    private Random random = new Random(System.currentTimeMillis());

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int rand = left + random.nextInt(right - left + 1);
        swap(nums, left, rand);
        int pivot = nums[left];
        // nums[left + 1, less) < pivot
        int lessThanPivot = left + 1;
        // nums[less, visit) = pivot
        int visit = left + 1;
        // nums(greater, right] > pivot
        int greaterThanPivot = right;

        while (visit <= greaterThanPivot) {
            if (nums[visit] < pivot) {
                swap(nums, visit, lessThanPivot);
                visit++;
                lessThanPivot++;
            } else if (nums[visit] == pivot) {
                visit++;
            } else {
                swap(nums, visit, greaterThanPivot);
                greaterThanPivot--;
            }
        }
        swap(nums, left, lessThanPivot - 1);
        quickSort(nums, left, lessThanPivot - 2);
        quickSort(nums, greaterThanPivot + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        /*
         * 随机交换快排
         * int rand = left + random.nextInt(right - left + 1);
         * swap(nums, left, rand);
         * int pivot = nums[left];
         * int j = left;
         * for (int i = left + 1; i <= right; i++) {
         * if (nums[i] <= pivot) {
         * j++;
         * swap(nums, i, j);
         * }
         * }
         * swap(nums, left, j);
         * return j;
         */
        /*
         * 双路快排
         */
        // int rand = left + random.nextInt(right - left + 1);
        // swap(nums, left, rand);
        // int pivot = nums[left];

        int less = left + 1;
        int greater = right;
        while (true) {
            while (less <= greater && nums[less] < nums[left]) {
                less++;
            }
            while (less <= greater && nums[greater] > nums[left]) {
                greater--;
            }
            if (less >= greater) {
                break;
            }
            swap(nums, less, greater);
            less++;
            greater--;
        }
        swap(nums, left, greater);
        return greater;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [5,2,3,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5,1,1,2,0,0]\n
 * // @lcpr case=end
 * 
 */
