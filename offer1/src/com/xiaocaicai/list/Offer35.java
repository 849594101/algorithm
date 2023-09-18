package com.xiaocaicai.list;

import com.xiaocaicai.util.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Offer35 {

    public Node copyRandomList(Node head) {
        // 第二种思路，往里面加进去链表
        //   1   2   3   4     5
        //   1 1 2 2 3 3 4 4 5 5
        if (head == null) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            Node temp = cur.next;
            Node node = new Node(cur.val);
            cur.next = node;
            node.next = temp;
            cur = temp;
        }
        cur = head;
        while (cur != null) {
            Node node = cur.next;
            if (cur.random != null) node.random = cur.random.next;
            cur = cur.next.next;
        }
        // 3. 拆分两链表
        cur = head.next;
        Node pre = head, res = head.next;
        while(cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;      // 返回新链表头节点
    }

    // 想半天用map存储，也没想出来怎么做
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node node = map.get(cur);
            node.next = map.get(cur.next);
            node.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
