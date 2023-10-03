package com.xiaocaicai.dynamic;

import com.xiaocaicai.backtracking.Offer12;

// LCR 127. 跳跃训练
public class Offer127 {

    public static void main(String[] args) {
        Offer127 as = new Offer127();
        int i = as.trainWays(5);
        System.out.println(i);
    }

    //今天的有氧运动训练内容是在一个长条形的平台上跳跃。平台有 num 个小格子，每次可以选择跳 一个格子 或者 两个格子。请返回在训练过程中，学员们共有多少种不同的跳跃方式。
    //
    //结果可能过大，因此结果需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
    public int trainWays(int num) {
        // 分析 dp[i]  跳跃到台阶为i的有dp[i]种跳跃方式
        // dp[i] 从哪推来的  与dp[i -1] dp[i -2]有关
        // dp[i] = dp[i - 1] + dp[i -2];
        int a = 1;
        int b = 1;
        if (num < 2) {
            return b;
        }
        int c = 0;
        for (int i = 2; i <= num; i++) {
            c = a + b;
            c = c >= 1000000007 ? c % 1000000007 : c;
            a = b;
            b = c;
        }
        return c;
    }
}
