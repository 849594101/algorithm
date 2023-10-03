package com.xiaocaicai.dynamic;
//连续天数的最高销售额
public class Offer161 {

    //某公司每日销售额记于整数数组 sales，请返回所有 连续 一或多天销售额总和的最大值。
    public int maxSales(int[] sales) {
        // 建立模型
        // dp[i] 在第i， 前面有连续销售额最大为dp[i]
        // dp[i]  一定是从dp[i -1]来的
        // dp[i], 如果sales[i] 是正数，并且，dp[i -1]的最大销售额是算上sales[i - 1] 那么 就可以直接加上sales[i]
        // 否则，比较

        // 是不是找到连续求和最大值就行了 不行要On

        // 没做出来，看题解
        // dp[i]  表示，以sales[i]为结尾的连续最大数组， 这样 我们是不是最大的连续数组就在dp中呢？  这样建模
        // dp[i]  与 dp[i -1] 有关， 当dp[i - 1] 小于0时， 去sales[i], 否则 sales[i]  + dp[i - 1]
        if (sales == null || sales.length == 0) {
            return 0;
        }
        int[] dp = new int[sales.length];

        dp[0] = sales[0];
        int res = dp[0];
        for (int i = 1; i < sales.length; i++) {
            dp[i] = dp[i - 1] < 0 ? sales[i] : dp[i - 1] + sales[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
