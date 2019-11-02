package com.github.ztgreat.linkedList.leetcode_2;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int cnt = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = p1;

        while (p1 != null && p2 != null) {

            p1.val = p1.val + p2.val + cnt;

            if (p1.val >= 10) {
                p1.val -= 10;
                cnt = 1;
            } else {
                cnt = 0;
            }
            p3 = p1;
            p1 = p1.next;
            p2 = p2.next;

        }

        while (p1 != null && cnt > 0) {
            p1.val = p1.val + cnt;
            if (p1.val >= 10) {
                p1.val -= 10;
                cnt = 1;
            } else {
                cnt = 0;
            }
            p3 = p1;
            p1 = p1.next;
        }
        p1 = p3;
        while (p2 != null) {
            p1.next = p2;
            p1.next.val += cnt;
            if (p1.next.val >= 10) {
                p1.next.val -= 10;
                cnt = 1;
            } else {
                cnt = 0;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        if (cnt != 0) {
            p1.next = new ListNode(cnt);
        }
        return l1;
    }
}