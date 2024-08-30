/*
 * @lc app=leetcode.cn id=82 lang=javascript
 *
 * [82] 删除排序链表中的重复元素 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
 var deleteDuplicates = function(head) {
    let nln =  new ListNode();
    nln.next = head;
    let slow = nln;
    let fast = head;

    while(fast !== null && fast.next !== null) {
        if(fast.val  !== fast.next.val) {
            slow = slow.next;
            fast = fast.next;
        } else {
            let val = fast.val;
            while(fast !== null && fast.val === val) {
                slow.next = fast.next;
                fast = fast.next;
            }
        }
    }

    return nln.next;
};
// @lc code=end

