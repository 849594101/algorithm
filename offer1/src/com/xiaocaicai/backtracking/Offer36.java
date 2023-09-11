package com.xiaocaicai.backtracking;

import com.xiaocaicai.util.TreeHelper;
import com.xiaocaicai.util.TreeNode;
//剑指 Offer 36. 二叉搜索树与双向链表
public class Offer36 {
    //参考大佬答案了、
    TreeNode pre, head;
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null)
            return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;

        dfs(root.left);
        if (pre != null) pre.right = root;
        else head = root;
        root.left = pre;
        pre = root;
        dfs(root.right);
    }
}
