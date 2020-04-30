package com.github.ztgreat.linkedList.leetcode_19;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 快慢指针，快指针先走n步，然后快慢一起走，直到快指针走到最后.
 * 要注意的是可能是要删除第一个节点，这个时候可以直接返回head -> next
 *
 * 如果数据不大，也可以使用递归
 */
class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return head;
        }
        if (head.next == null && n == 1) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        if (first == null) {
            head = head.next;
            return head;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;

    }

}