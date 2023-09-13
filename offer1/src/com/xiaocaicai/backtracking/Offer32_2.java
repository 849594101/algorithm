package com.xiaocaicai.backtracking;

import com.xiaocaicai.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Offer32_2 {

    public final List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
//        handler(root, 0 );
        handler2(root);
        return list;
    }

    private void handler2(TreeNode root) {
        // 借助queue
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list2 = new ArrayList<>();
            while (len > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                list2.add(node.val);
                len--;
            }
            list.add(list2);
        }
    }

    private void handler(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        deep++;
        if (list.size() < deep) {
            list.add(new ArrayList<>());
        }
        list.get(deep - 1).add(root.val);
        handler(root.left, deep);
        handler(root.right, deep);
    }



}
