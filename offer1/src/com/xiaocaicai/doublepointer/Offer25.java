package com.xiaocaicai.doublepointer;

import com.xiaocaicai.backtracking.Offer34;
import com.xiaocaicai.util.ListNode;
import com.xiaocaicai.util.ListNodeHelper;

public class Offer25 {

    public static void main(String[] args) {
        Offer25 offer25 = new Offer25();
        ListNode l1 = ListNodeHelper.getListNode("[1,2,4]");
        ListNode l2 = ListNodeHelper.getListNode("[1,3,4]");
        ListNode listNode = offer25.mergeTwoLists(l1, l2);
        System.out.println();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return head.next;
    }

}
