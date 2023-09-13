package com.xiaocaicai.backtracking;

import com.xiaocaicai.util.TreeHelper;
import com.xiaocaicai.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//剑指 Offer 54. 二叉搜索树的第k大节点
public class Offer54 {
    public static void main(String[] args) throws Exception {
        String str = "[3,1,4,null,2]";
        TreeNode tree = TreeHelper.getTree(str);
        Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass(Offer54.class.getName());
        Offer54 offer54 = (Offer54) aClass.newInstance();
        int i = offer54.kthLargest(tree, 1);
        System.out.println();
    }

    // 二叉搜索树 中序遍历 是有序的 递增序列。   所以逆中序是 降序的
    int res, k;
    public int kthLargest2(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.right);

        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.left);
    }


    // 二叉搜索树性质没用上
    private final List<Integer> list = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return -1;
        }
        handle(root);
        Collections.sort(list);
        Collections.reverse(list);
        return k > list.size() ? list.get(list.size() - 1) : list.get(k - 1);
    }

    private void handle(TreeNode root) {
        if (root == null) return ;
        list.add(root.val);
        handle(root.left);
        handle(root.right);
    }
}
