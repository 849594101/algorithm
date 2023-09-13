package com.xiaocaicai.backtracking;

import com.xiaocaicai.util.TreeHelper;
import com.xiaocaicai.util.TreeNode;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Offer37 {

    public static void main(String[] args) throws ClassNotFoundException {
        Codec codec = new Codec();
        TreeNode treeNode = codec.deserialize("[1,2,3,null,null,4,5]");
        TreeHelper.printTree(treeNode);
        String result = codec.serialize(treeNode);
        System.out.println(result);

    }

    static public class Codec {
        private final StringBuilder sb = new StringBuilder();
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>() {{add(root);}};

            sb.append("[");
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val + ",");
                    queue.add(node.left);
                    queue.add(node.right);
                }
                else sb.append("null,");
            }
            String re = sb.substring(0, sb.length() - 1);
            return re + "]";
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String x) {
            if ("[]".equals(x)){
                return null;
            }
            String data = x.substring(1, x.length() - 1);
            String[] nodes = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int i = 1;
            while (!queue.isEmpty() && i < nodes.length) {
                TreeNode cur = queue.poll();
                if (i < nodes.length &&  !nodes[i].equals("null")) {
                    cur.left = new TreeNode(Integer.parseInt(nodes[i]));
                    queue.offer(cur.left);
                }
                i++;
                if (i < nodes.length &&  !nodes[i].equals("null")){
                    cur.right = new TreeNode(Integer.parseInt(nodes[i]));
                    queue.offer(cur.right);
                }
                i++;
            }
            return root;
        }
    }
}
