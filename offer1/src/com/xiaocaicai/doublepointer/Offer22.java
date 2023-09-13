package com.xiaocaicai.doublepointer;

import com.xiaocaicai.util.ListNode;

public class Offer22 {

    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            int length = 0;
            ListNode cur = head;
            while (cur != null) {
                length++;
                cur = cur.next;
            }
            cur = head;
            int num = length - k;
            while (num > 0 && cur != null) {
                cur = cur.next;
                num--;
            }
            return cur;
        }
    }
}
