/*
 * @lc app=leetcode.cn id=21 lang=javascript
 *
 * [21] 合并两个有序链表
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
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    let nln = new ListNode();
    let middle = nln;

    while(l1 !== null && l2 !== null) {
        if(l1.val > l2.val) {
            middle.next = l2;
            l2 = l2.next;
        } else {
            middle.next = l1;
            l1 = l1.next;
        }
        middle = middle.next;
    }

    if(l1 === null) {
        middle.next = l2;
    }
    if(l2 === null) {
        middle.next = l1;
    }

    return nln.next;
};
// @lc code=end

