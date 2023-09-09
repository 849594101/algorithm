package com.xiaocaicai.backtracking;

import com.xiaocaicai.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

// 对称的二叉树
public class Offer28 {




    public boolean isSymmetric(TreeNode root) {
//        return judge(root);
        if (root == null) return true;
        return judge2(root.left, root.right);
    }

    // 递归写法
    public boolean judge2(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null || node1.val != node2.val) return false;
        return judge2(node1.left , node2.right) && judge2(node1.right, node2.left);
    }

    // 队列
    private boolean judge(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.pollFirst();
            TreeNode right = deque.pollLast();
            if (left == right && left == null) continue;
            if (left == null || right == null || (left.val != right.val)) return false;

            deque.offerFirst(left.right);
            deque.offerFirst(left.left);
            deque.offerLast(right.left);
            deque.offerLast(right.right);
        }
        return true;
    }
}
