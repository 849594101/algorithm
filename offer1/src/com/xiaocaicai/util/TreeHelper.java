package com.xiaocaicai.util;

import com.alibaba.fastjson.JSONArray;
import com.google.common.base.Joiner;
import com.google.common.primitives.Ints;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;


public class TreeHelper {

    public static void main(String[] args) {
        String str = "[4,2,7,null,3,6,9]";
        TreeNode tree = getTree(str);
        printTree(tree);
    }


    public static void printTree(TreeNode root){
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            System.out.print("Depth " + depth + ": ");

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    System.out.print(current.val + " ");
                    queue.offer(current.left);
                    queue.offer(current.right);
                } else {
                    System.out.print("null ");
                }
            }

            System.out.println(); // 换行到下一层
            depth++;
        }
    }

    public static TreeNode getTree(String str) {
        str = str.substring(1, str.length() - 1); // 去掉字符串开头的"["和结尾的"]"
        if (str.isEmpty()) {
            return null;
        }
        str.replace("[", "");
        str.replace("]", "");
        String[] values = str.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();
            if (!values[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(current.left);
            }
            i++;

            if (i < values.length && !values[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
}
