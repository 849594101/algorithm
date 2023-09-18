package com.xiaocaicai.list;

import com.xiaocaicai.util.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Offer06 {

    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        List<Integer> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        Collections.reverse(list);
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
}
