package com.xiaocaicai.doublepointer;

import com.sun.deploy.util.StringUtils;

public class Offer58 {
    public static void main(String[] args) {
        Offer58 offer58 = new Offer58();
        String result = offer58.reverseWords("a good   example");
        System.out.println();
    }
    public String reverseWords(String s) {
        String str = s.trim();
        String[] word = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = word.length - 1; i >= 0; i--) {
            if ("".equals(word[i])) {
                continue;
            }
            sb.append(word[i] + " ");
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }
}
