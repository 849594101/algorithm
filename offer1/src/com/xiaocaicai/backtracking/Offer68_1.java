package com.xiaocaicai.backtracking;

import com.xiaocaicai.util.TreeNode;
// 二叉搜索树公共祖先
public class Offer68_1 {

    //当 p,qp, qp,q 都在 rootrootroot 的 右子树 中，则开启递归 root.rightroot.rightroot.right 并返回；
    //否则，当 p,qp, qp,q 都在 rootrootroot 的 左子树 中，则开启递归 root.leftroot.leftroot.left 并返回；
    //返回值： 最近公共祖先 rootrootroot 。
    //
    //作者：Krahets
    //链接：https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/solutions/216894/mian-shi-ti-68-i-er-cha-sou-suo-shu-de-zui-jin-g-7/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root.val < p.val && root.val < q.val)
                return lowestCommonAncestor(root.right, p, q);
            if(root.val > p.val && root.val > q.val)
                return lowestCommonAncestor(root.left, p, q);
            return root;
        }
    }
//
//    作者：Krahets
//    链接：https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/solutions/216894/mian-shi-ti-68-i-er-cha-sou-suo-shu-de-zui-jin-g-7/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    // 参考了代码随想录
    // 找公共祖先， 我门最希望是从最下测开始遍历，然后递归回溯

    //怎么判断一个节点是否是p、q祖先呢？
    //首先想到的是这个节点 的左或右 子树 都有p、q
    // 然后我们是从最下测开始遍历的，下测找到就返回给上测，层层返回
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {   //遍历到寻找的节点了
                return root;
            }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left == null && right == null) {
                return null; // 左右子树都没找到
            } else if (left == null && right != null) {
                return right;  // 右测找到
            } else if (left != null && right == null) {
                return left;
            } else {
                // 从这个节点，左侧，右侧都找到包含的
                return root;
            }
        }
    }
}
