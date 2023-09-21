package com.xiaocaicai.stakandqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer09 {


    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

    static class CQueue {
        LinkedList<Integer> stack = new LinkedList<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            stack.addLast(value);
        }
        // 这里用了list特性，可以拥有两个栈操作的特性
        // 如果按照题意，两个栈，先进后出操作。  delte时候，需要将一个栈倒出到另一个栈中，再删除。
        public int deleteHead() {
            return stack.isEmpty() ? -1 : stack.removeFirst();
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
}

