package com.xiaocaicai.backtracking;

import com.xiaocaicai.util.TreeNode;

public class Offer55_1 {




    class Solution {
        int res;
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root, 1);
            return res;
        }

        public void dfs(TreeNode root, int deep) {
            if (root == null) {
                res = Math.max(res, deep - 1);
                return;
            }
            dfs(root.left, deep + 1);
            dfs(root.right, deep + 1);
        }
    }
}
