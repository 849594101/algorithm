package com.xiaocaicai.dynamic;

import com.alibaba.fastjson.JSON;

//LCR 166. 珠宝的最高价值
public class Offer166 {

    public static void main(String[] args) {
        String ss = "[[1,3,1],[1,5,1],[4,2,1]]";
        int[][] ints = JSON.parseObject(ss, int[][].class);
        Offer166 sd = new Offer166();
        int res = sd.jewelleryValue(ints);
        System.out.println(res);
    }

    public int jewelleryValue(int[][] frame) {
            // 从左上到右下
            // dp[i][j] 表示到到ij位置时候，获得的最大价值
            // dp[i][j] 是从i-1 j, i j-1 过来的
            // dp[i][j] = Max( )
            int m = frame.length;
            int n = frame[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = frame[0][0];
            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = dp[i - 1][0] + frame[i][0];
            }
            for (int i = 1; i < dp[0].length; i++) {
                dp[0][i] = dp[0][i - 1] + frame[0][i];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] += Math.max(dp[i - 1][j], dp[i][j - 1]) + frame[i][j];
                }
            }
            return dp[m - 1][n - 1];
    }
}
