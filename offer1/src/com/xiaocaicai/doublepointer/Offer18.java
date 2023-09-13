package com.xiaocaicai.doublepointer;

import com.xiaocaicai.util.ListNode;

public class Offer18 {

    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            ListNode cur = head;
            ListNode pre = cur;
            if (head.val == val) {
                return head.next == null ? null : head.next;
            }
            while (cur.val != val) {
                pre = cur;
                cur = cur.next;
            }
            if (cur.next == null) {
                pre.next = null;
                return head;
            }
            pre.next = cur.next;
            cur.next = null;
            return head;
        }
    }
}
