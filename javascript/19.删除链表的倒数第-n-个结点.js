/*
 * @lc app=leetcode.cn id=19 lang=javascript
 *
 * [19] 删除链表的倒数第 N 个结点
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
 * @param {number} n
 * @return {ListNode}
 */
 function ListNode(val, next) {
     this.val = (val===undefined ? 0 : val)
     this.next = (next===undefined ? null : next)
}

var removeNthFromEnd = function(head, n) {
    let empty = new ListNode(0,head);
    let fast = empty;
    let slow = empty;
    for(let i = 0; i <= n; i++) {
        fast = fast.next;
    }
    while(fast != null) {
        fast = fast.next;
        slow = slow.next;
    }

    slow.next = slow.next.next;
    return empty.next;
};

// @lc code=end

