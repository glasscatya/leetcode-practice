/*
 * @lc app=leetcode.cn id=92 lang=javascript
 *
 * [92] 反转链表 II
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
 * @param {number} left
 * @param {number} right
 * @return {ListNode}
*/
   
function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
}
var reverseBetween = function(head, left, right) {
    let dummy = new ListNode(0, head);
    let node = dummy;
    for(let i = 0; i < left - 1; i++) {
        node = node.next;
    }
    let curr = node.next;
    let last = node;
    for(let i = 0; i  <= right - left; i++) {
        let next = curr.next;
        curr.next = last;
        last = curr;
        curr = next;
    }
    node.next.next = curr;
    node.next = last;
    return dummy.next;
};


// @lc code=end

