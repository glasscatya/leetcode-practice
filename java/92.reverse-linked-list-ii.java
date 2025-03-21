/*
 * @lc app=leetcode.cn id=92 lang=java
 * @lcpr version=30204
 *
 * [92] 反转链表 II
 */


// @lcpr-template-start
import java.lang.classfile.components.ClassPrinter.ListNode;
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        var sentry = new ListNode(-1, head);
        var frist = sentry;
        //找到要反转的起点的前一个
        for (int i = 0; i < left - 1; i++) {
            frist = frist.next;
        }
        var cur = frist.next;
        var pre = frist;
        //总共要反转 right - left + 1 个元素
        for (int i = 0; i < right - left + 1; i++) {
            var tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        frist.next.next = cur;
        frist.next = pre;
        return frist;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n2\n4\n
// @lcpr case=end

// @lcpr case=start
// [5]\n1\n1\n
// @lcpr case=end

 */

