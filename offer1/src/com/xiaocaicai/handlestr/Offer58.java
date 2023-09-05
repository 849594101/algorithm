package com.xiaocaicai.handlestr;


public class Offer58 {

    public static void main(String[] args) {
        System.out.println(reverseLeftWords());
    }

    private static String reverseLeftWords() {
        String s = s = "abcdefg";
        int k = 2;
        if (s == null || s.length() < k) {
            return s;
        }
        String str = s.substring(0, k);
        String str2 = s.substring(k, s.length());
        return str2 + str;
    }
}
