package com.xiaocaicai.doublepointer;

import java.util.Arrays;

public class Offer21 {

    // yes  也可以双指针来做
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] result = Arrays.stream(nums).boxed().sorted((a, b) -> {
            boolean flag1 = a % 2 == 1;
            boolean flag2 = b % 2 == 1;
            if (flag1 && !flag2) {
                return -1;
            } else if (!flag1 && flag2) {
                return 1;
            }
            return 0;
        }).mapToInt(Integer::intValue).toArray();
        return result;
    }
}
