/*
 * @lc app=leetcode.cn id=707 lang=java
 * @lcpr version=30204
 *
 * [707] 设计链表
 */


// @lcpr-template-start
import java.util.*;

import MyLinkedList.Node;
// @lcpr-template-end
// @lc code=start
class MyLinkedList {
    private Node<Integer> head = null;
    private int size = 0;

    private static class Node<Integer> {
        private Integer value;
        private Node<Integer> next;

        public Node(Integer value, Node<Integer> next) {
            this.value = value;
            this.next = next;
        }
    }

    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        if (size == 0 || index >= size) return -1;
        Node<Integer> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }
    
    public void addAtHead(int val) {
        Node<Integer> node = new Node<>(val, head);
        head = node;
        size++;
    }
    
    public void addAtTail(int val) {
        if (head == null) {
            head = new Node<>(val, null);
        } else {
            Node<Integer> cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node<>(val, null);
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index <= 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node<Integer> cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            Node<Integer> node = new Node<>(val, cur.next);
            cur.next = node;
            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index >= size) return;
        if (size == 0) return;
        if (index == 0) {
            head = head.next;
        } else {
            Node<Integer> cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            if (cur.next != null) {
                cur.next = cur.next.next;
            }
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end



