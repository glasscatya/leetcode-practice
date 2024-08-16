/*
 * @lc app=leetcode.cn id=24 lang=c
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode
{
    int val;
    struct ListNode *next;
};

struct ListNode* swapPairs(struct ListNode* head) {
    struct ListNode* dummyHead = malloc(sizeof(struct ListNode));
    dummyHead->next = head;
    struct ListNode* cur = dummyHead;

    while(cur->next != NULL && cur->next->next != NULL) {
        struct ListNode* tmp1 = cur->next; // 记录临时节点
        struct ListNode* tmp2 = cur->next->next->next; // 记录临时节点

        cur->next = cur->next->next;
        cur->next = tmp1;
        cur->next->next = tmp2;

        cur = cur->next->next;
    }

    return dummyHead->next;

}
// @lc code=end

