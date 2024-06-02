/*
 * @lc app=leetcode.cn id=2 lang=javascript
 *
 * [2] 两数相加
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
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    let nln = new ListNode();
    //使用链表的引用来对链表操作，如果直接对链表操作，会摧毁链表的结构。
    let middle = nln;
    let tenIf = 0;
    while(l1 !== null || l2 !== null) {
        let sum =  0;
        if(l1 !== null){
            sum += l1.val;
            l1 = l1.next;
        }
        if(l2 !== null){
            sum += l2.val;
            l2 = l2.next;
        }
        sum += tenIf;
        middle.next = new ListNode(sum % 10);
        tenIf = Math.floor(sum / 10);
        middle = middle.next;
    }

    if(tenIf > 0){
        middle.next = new ListNode(tenIf);
        //在为了更加方便地对链表写入数据，使用了空头链表  返回时，需将空头链表给移除！
        return nln.next;
    }
    return nln.next;
};
// @lc code=end

