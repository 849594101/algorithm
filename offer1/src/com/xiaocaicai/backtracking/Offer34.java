package com.xiaocaicai.backtracking;

import com.xiaocaicai.util.TreeHelper;
import com.xiaocaicai.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Offer34 {

    public static void main(String[] args) {
        Offer34 offer34 = new Offer34();
        TreeNode tree = TreeHelper.getTree("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        offer34.pathSum(tree, 22);
    }
    private final List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {

        back(root, target);
        return result;
    }
    //递归
    public void back2(TreeNode root, int target) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            Integer sum = list.stream().reduce(0, Integer::sum);
            if (sum == target) {
                result.add(new ArrayList<>(list));
            }
        }

        back(root.left, target);

        back(root.right, target);

    }

    // 回溯
    private final List<Integer> list = new ArrayList<>();
    public void back(TreeNode root, int target) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            Integer sum = list.stream().reduce(0, Integer::sum);
            if (sum == target) {
                result.add(new ArrayList<>(list));
            }
        }

        if (root.left  != null){
            back(root.left, target);
            list.remove(list.size() -  1);
        }

        if (root.right != null) {
            back(root.right, target);
            list.remove(list.size() -  1);
        }

    }
}
