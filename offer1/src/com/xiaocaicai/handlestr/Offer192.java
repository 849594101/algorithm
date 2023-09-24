package com.xiaocaicai.handlestr;

import java.math.BigInteger;

public class Offer192 {

    public static void main(String[] args) {
        Offer192 offer192 = new Offer192();
        String str = " 1192820738r2";
        int i = offer192.strToInt(str);
        System.out.println(Integer.MAX_VALUE);
    }

    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int res = 0;
        int binary = Integer.MAX_VALUE / 10;
        int sign = 1;
        int i = 1;
        if (chars[0] == '-') sign = -1;
        else if (chars[0] != '+') i = 0;
        for (int j = i; j < chars.length; j++) {
            if (chars[j] < '0' || chars[j] > '9') break;
            if (res > binary || res == binary && chars[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + chars[j] - '0';
        }
        return sign * res;
    }

    // 解析异常
    public int strToInt2(String str) {
        String str1 = str.trim();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            Character ch = str1.charAt(i);
            if ((ch == '-' || ch == '+') && i == 0) {
                sb.append(ch);
            } else if (ch >= '0' && ch <= '9') {
                sb.append(ch);
            } else {
                break;
            }
        }
        if (sb.length() == 0 || sb.toString().equals("-") || sb.toString().equals("+")) {
            return 0;
        }

        BigInteger res = new BigInteger(sb.toString());

        return res.intValue();
    }
}
