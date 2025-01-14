/*
 * @lc app=leetcode.cn id=234 lang=java
 * @lcpr version=30204
 *
 * [234] 回文链表
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (head.next != null) {
            stack.push(head.val);
            head = head.next;
            if (head.val == head.next.val) {
                break;
            }
        }
        
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n
// @lcpr case=end

 */

