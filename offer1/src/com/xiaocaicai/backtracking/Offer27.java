package com.xiaocaicai.backtracking;

import com.xiaocaicai.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

//剑指 Offer 27. 二叉树的镜像
public class Offer27 {


    public TreeNode mirrorTree(TreeNode root) {
//        return handle(root);
        return handle2(root);
    }
    // 层序
    public TreeNode handle2(TreeNode node) {
        if (node == null) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0){
                TreeNode n = queue.poll();
                swap(n);
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
                len--;
            }
        }
        return node;
    }

    // 前序
    public TreeNode handle(TreeNode node) {
        if (node == null) return null;
        swap(node);
        if (node.left != null) handle(node.left);
        if (node.right != null) handle(node.right);
        return node;
    }

    public void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

}
