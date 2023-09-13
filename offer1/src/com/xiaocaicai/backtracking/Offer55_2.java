package com.xiaocaicai.backtracking;

import com.xiaocaicai.util.TreeNode;

public class Offer55_2 {

    class Solution {
        //思路是对二叉树做后序遍历，从底至顶返回子树深度，若判定某子树不是平衡树则 “剪枝” ，直接向上返回
        public boolean isBalanced(TreeNode root) {
           return recur(root) != -1;
        }

        private int recur(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = recur(root.left);
            if (left == -1) return -1;
            int right = recur(root.right);
            if (right == -1) return -1;
            return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
        }


        public boolean isBalanced2(TreeNode root) {
            if (root == null) {
                return true;
            }
            boolean left = handle(root.left);
            boolean right = handle(root.right);
            return left && right;
        }

        public boolean handle(TreeNode treeNode) {

            int left = maxDepth(treeNode.left);
            int right = maxDepth(treeNode.right);
            return Math.abs(left - right) <= 1;
        }

        // 求高度
        int res;
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            sss(root, 1);
            return res;
        }

        public void sss(TreeNode root, int deep) {
            if (root == null) {
                res = Math.max(res, deep - 1);
                return;
            }
            sss(root.left, deep + 1);
            sss(root.right, deep + 1);
        }

        // 特殊情况 当一边是null时，还没处理好
        private int result = Integer.MIN_VALUE;
        private boolean flag = true;
        private void dfs(TreeNode root, int deep) {
            if (root == null) {
                result  = Math.max(result, deep - 1);
            }

            if (root.left == null && root.right == null) {
                flag = result != Integer.MIN_VALUE && result > deep + 1 ? false : true;
                result  = Math.max(result, deep);
                return;
            }

            dfs(root.left, deep + 1);

            dfs(root.right, deep + 1);
        }
    }
}
