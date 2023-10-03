package com.xiaocaicai.dynamic;

import com.alibaba.fastjson.JSON;

//买卖芯片的最佳时机
public class Offer188 {

    public static void main(String[] args) {
        Offer188 os = new Offer188();
//        String ss = "[3, 6, 2, 9, 8, 5]";
        String ss = "[8, 12, 15, 7, 3, 10]";
        int[] prices = JSON.parseObject(ss, int[].class);
        int res = os.bestTiming(prices);
        System.out.println(res);
    }
    //你只能选择 某一天 买入芯片，
    public int bestTiming(int[] prices) {
        // dp[i] 到第i天买入芯片可以获取的最大利润
        // dp[i] 从哪来 dp[i - 1] dp[i - 2] ..
        // 某天买入芯片的利润 比如第1天买 第2天卖， dp[i] = b - a;
        // 然后第2天买，第三天卖，dp[i] = c - b + b - a  = c - a;
        // 如果说 第i股票比前天股票贵，那么可以获取净利润 dp[i] =  d[i -1] + prices[i];
        // dp[i] = dp[i - 1] + prices[i] - prices[i - 1] 或者 dp[i] = dp[i - 1];

        // 某一天买然后卖
        // dp[i] = Math.max(dp[i -1],  xx ),  xx是i天卖时候的 prices[i] - prices[i - 1];

        int day = prices.length;
        int[] dp = new int[day + 1];
        dp[0] = 0;
        dp[1] = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 2; i <= prices.length; i++) {
            min = Math.min(min, prices[i - 2]);
            dp[i] = Math.max(dp[i - 1], prices[i - 1] - min);
        }
        return dp[day];
    }
}
