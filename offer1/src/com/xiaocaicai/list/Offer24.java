package com.xiaocaicai.list;

import com.xiaocaicai.util.ListNode;

public class Offer24 {

    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        pre.next = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
