package com.xiaocaicai.doublepointer;

import java.lang.reflect.ParameterizedType;

public class Offer57 {


    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = nums[left] + nums[right];
            if (mid < target) {
                left++;
            } else if (mid > target) {
                right--;
            } else {
                return new int[]{nums[left], nums[right]};
            }

        }
        return null;
    }

//    public int[] twoSum(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//
//        while (left <= right) {
//            int mid = (right + left) >> 1;
//            if (nums[mid] < target) {
//                left++;
//            } else if (nums[mid] > target) {
//                right--;
//            } else {
//                return new int[]{nums[left], nums[right]};
//            }
//        }
//        return null;
//    }
}
