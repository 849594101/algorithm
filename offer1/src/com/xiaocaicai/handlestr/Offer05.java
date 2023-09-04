package com.xiaocaicai.handlestr;

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
public class Offer05 {

    public static void main(String[] args) {
        String s = "We are happy.";
        // c++中String是可变的，可以统计个数的方式完成
    }

    // 效率最低
    private static String replaceSpace2() {
        String str = "We are happy.";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) + "").equals(" ")) {
                stringBuilder.append("%20");

            } else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }


    public String replaceSpace1(String s) {
        return s.replace(" ", "%20");
    }
}
