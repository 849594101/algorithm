package com.xiaocaicai.util;

public class ListNodeHelper {


    public static ListNode getListNode(String str) {
        str = str.substring(1, str.length() - 1);
        String[] values = str.split(",");
        ListNode head = new ListNode(Integer.parseInt(values[0]));
        ListNode cur = head;
        int i = 1;
        int length = values.length;
        while (i < length){
            cur.next = new ListNode(Integer.parseInt(values[i]));
            cur = cur.next;
            i++;
        }
        return head;
    }
}
