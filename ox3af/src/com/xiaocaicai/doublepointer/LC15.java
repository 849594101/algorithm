package com.xiaocaicai.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {

    public static void main(String[] args) {
        LC15 lc15 = new LC15();
        List<List<Integer>> lists = lc15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int left = 1;
        int right = nums.length - 1;
        for (; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                continue;
            }
            if (nums[i] + nums[nums.length - 2] + nums[nums.length - 1] < 0) {
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[left], nums[right])));

                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }

            }
        }
        //            int[][] ans = res.stream().map(inner -> inner.stream()
//                            .mapToInt(Integer::intValue).toArray())
//                    .toArray(int[][]::new);
        return res;
    }
}
