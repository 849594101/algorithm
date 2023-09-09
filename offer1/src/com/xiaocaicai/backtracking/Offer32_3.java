package com.xiaocaicai.backtracking;


import java.util.*;

// 之字打印树
public class Offer32_3 {


    private final List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        handler4(root);
        return result;
    }

    // 层序遍历时，最里面那个循环是有序的，所以可以将其倒序
    // 我们可以用个数据结构，在存储时候根据 奇偶层数 控制其加入的位置。
    public void handler4(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> list = new ArrayDeque<>();
        list.offer(root);
        while (!list.isEmpty()) {
            int len = list.size();
            LinkedList<Integer> list2 = new LinkedList<>();
            while (len > 0) {
                TreeNode node = list.poll();
                if (node.left != null) list.offer(node.left);
                if (node.right != null) list.offer(node.right);
                if (result.size() % 2 == 0) list2.addLast(node.val);
                else list2.addFirst(node.val);
                len--;
            }
            result.add(list2);
        }
    }

    // 这都没想出来， 将该层倒序。
    public void handler3(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int len = list.size();
            List<Integer> list2 = new ArrayList<>();
            while (len > 0) {
                TreeNode node1 = list.removeFirst();
                if (node1.left != null) list.add(node1.left);
                if (node1.right != null) list.add(node1.right);
                list2.add(node1.val);
                len--;
            }
            if (result.size() % 2 == 1) Collections.reverse(list2);
            result.add(list2);
        }
    }

    // 同样问题
    public void handle2r(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int len = list.size();
            List<Integer> list2 = new ArrayList<>();
            while (len > 0) {
                TreeNode node1 = list.removeFirst();
                if (node1.left != null) list.add(node1.left);
                if (node1.right != null) list.add(node1.right);
                list2.add(node1.val);
                len--;
            }
        }
    }

    // 只能调节单个节点 的左右孩子顺序，  而左右子树无法调整
    public void handler(TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        deep++;
        if (result.size() < deep) {
            result.add(new ArrayList<>());
        }
        result.get(deep - 1).add(node.val);
        if (deep % 2 == 0) {
            handler(node.left, deep);
            handler(node.right, deep);
        } else {
            handler(node.right, deep);
            handler(node.left, deep);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
