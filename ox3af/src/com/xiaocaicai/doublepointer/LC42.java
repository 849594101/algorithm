package com.xiaocaicai.doublepointer;

public class LC42 {

    public int trap(int[] height) {
        // 每个槽位雨水在于 左侧 最高处， 右侧最高处.
        // 前缀最大值 比 后缀最大值小，那么这快位置高度就是前缀最大值
        int left = 0;
        int pre_max = 0;
        int right = height.length - 1;
        int suf_max = 0;
        int ans = 0;
        while (left <= right) {
            pre_max = Math.max(pre_max, height[left]);
            suf_max = Math.max(suf_max, height[right]);

            if (pre_max < suf_max) {
                ans += pre_max - height[left];
                left++;
            } else {
                ans += suf_max - height[right];
                right--;
            }
        }
        return ans;
    }
}
