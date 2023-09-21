package com.xiaocaicai.doublepointer;

public class LC11 {

    public int maxArea(int[] height) {
        // 从左右找最高的
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int aer = (right - left) * Math.min(height[left], height[right]);
            ans = Math.max(ans, aer);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
