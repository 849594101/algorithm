package com.xiaocaicai.backtracking;

import com.xiaocaicai.util.TreeNode;

import java.util.*;
import java.util.function.Supplier;

//剑指 Offer 32 - I. 从上到下打印二叉树
public class Offer32_1 {



    public final List<List<Integer>> list = new ArrayList<>();
    public int[] levelOrder(TreeNode root) {
        // 层序遍历即可
        // 1.利用queue
        if (root == null) {
            return new int[0];
        }
//        handle(root, 0);
        handle2(root);
        int[] result = list.stream()
                .flatMap(List::stream)
                .mapToInt(Integer::intValue)
                .toArray();
        return result;
    }

    // 利用queue写法
    public void handle2(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> subList = new ArrayList<>();
            while (len > 0) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                len--;
            }
            list.add(subList);
        }
    }

    // 递归写法
    public void handle(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        deep++;
        if (list.size() < deep) {
            list.add(new ArrayList<>());
        }
        list.get(deep -1).add(root.val);
        handle(root.left, deep);
        handle(root.right, deep);
    }
}
