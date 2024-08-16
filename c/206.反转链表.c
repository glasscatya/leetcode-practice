/*
 * @lc app=leetcode.cn id=206 lang=c
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

// struct ListNode
// {
//     int val;
//     struct ListNode *next;
// };

struct ListNode *reverseList(struct ListNode *head)
{
    struct ListNode *cur;
    struct ListNode *forward;

    cur = head;
    if(!head) return cur;

    forward = head->next;
    cur->next = NULL;

    while (forward != NULL)
    {
        cur = forward;
        cur->next = head;
        head = cur;
        forward = forward->next;
    }

    return cur;
}
// @lc code=end
