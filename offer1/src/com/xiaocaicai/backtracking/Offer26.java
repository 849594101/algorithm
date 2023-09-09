package com.xiaocaicai.backtracking;

import com.xiaocaicai.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

//树的子结构
public class Offer26 {
    public static void main(String[] args) {
        Offer26 offer26 = new Offer26();


    }


    //若树 BBB 是树 AAA 的子结构，则子结构的根节点可能为树 AAA 的任意一个节点。因此，判断树 BBB 是否是树 AAA 的子结构，需完成以下两步工作：
    //
    //先序遍历树 AAA 中的每个节点 nAn_An
    //判断树 AAA 中 以 nAn_An为根节点的子树 是否包含树 BBB 。（对应函数 recur(A, B)）
    //
    //作者：Krahets
    //链接：https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/solutions/144306/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (judge(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean judge(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null)  return false;
        if (a.val != b.val) return false;
        return judge(a.left, b.left) && judge(a.right, b.right);
    }


    // 处理不了，先序遍历会遇到空情况不好处理， 没有调用 queue.contains()方法
    public boolean isSubStructure1(TreeNode A, TreeNode B) {
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> queue2 = new LinkedList<>();
        handle(A, queue);
        handle(B, queue2);
        return false;
    }

    private void handle(TreeNode a, Deque<TreeNode> queue) {
        if (a == null) return;
        queue.offer(a);
        handle(a.left, queue);
        handle(a.right, queue);
    }
}
