package com.xiaocaicai.stakandqueue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Offer30 {

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.min();
     */
    class MinStack {

        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            list.add(x);
            if (list2.isEmpty() || list2.getLast() > x) {
                list2.add(x);
            }
         }

        public void pop() {
            if (list.removeLast().equals(list2.getLast())) {
                list2.removeLast();
            }
        }

        public int top() {
            return list.getLast();
        }

        // 要求这三个操作时间复杂度都是O1的
        public int min() {
            return   list2.getLast();
        }
    }
}
