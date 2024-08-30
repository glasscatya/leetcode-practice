/*
 * @lc app=leetcode.cn id=160 lang=javascript
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
var getIntersectionNode = function(headA, headB) {
    let a = headA;
    let b = headB;
    while(a !== null || b !== null){
        if(a === null) {
            a = headB;
        }

        if(b === null) {
            b = headA;
        }

        if(a === b) {
            return a;
        } else {
            a = a.next;
            b = b.next;
        }
    }
    return null;
};
// @lc code=end

