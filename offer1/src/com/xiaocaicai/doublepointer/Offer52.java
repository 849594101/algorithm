package com.xiaocaicai.doublepointer;

import com.xiaocaicai.util.ListNode;

public class Offer52 {

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB) {
            return headA;
        }
        // 快慢指针
        ListNode left = headA;
        ListNode right = headB;
        // A + x = l1
        // B + x = l2
        // B - A = l2 - l1
        int a1 = 0;
        int b1 = 0;
        while (left != null) {
            left = left.next;
            a1++;
        }
        while (right != null) {
            right = right.next;
            b1++;
        }
        left = headA;
        right = headB;
        if (a1 < b1) {
            left = headB;
            right = headA;
        }

        int ab = Math.abs(b1 - a1);
        while (ab > 0) {
            left = left.next;
            ab--;
        }
        while (left != null && right != null) {
            if (left == right) {
                return left;
            }
            left = left.next;
            right = right.next;

        }
        return null;
    }
}
