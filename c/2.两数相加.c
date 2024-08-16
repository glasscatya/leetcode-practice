/*
 * @lc app=leetcode.cn id=2 lang=c
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode {
    int val;
    struct ListNode *next;
};

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
    //储存进位
    int carry = 0;
    // 创造一个头结点，让头指针dummy指向它
    struct ListNode* dummy = malloc(sizeof(struct ListNode));
    // 创造一个指针，让cur指向最后
    struct ListNode* cur = dummy;

    //他们三个中有一个还有值 进行下一轮循环
    while(l1 || l2 || carry) {
        if(l1) {
            carry += l1->val;
            l1 = l1->next;
        }

        if(l2) {
            carry += l2->val;
            l2 = l2->next;
        }

        cur->next = malloc(sizeof(struct ListNode));
        cur->val = carry % 10;
        cur->next = (void *)0;

        carry /= 10;
    }

    return dummy->next;
}
// @lc code=end

