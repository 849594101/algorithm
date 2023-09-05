package com.xiaocaicai.handlestr;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.parser.ParserConfig;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//表示数值的字符串

/**
 *
 */
public class Offer20 {

    //有限状态自动机

    //状态定义：
    //
    //按照字符串从左到右的顺序，定义以下 9 种状态。
    //
    //开始的空格
    //幂符号前的正负号
    //小数点前的数字
    //小数点、小数点后的数字
    //当小数点前为空格时，小数点、小数点后的数字
    //幂符号
    //幂符号后的正负号
    //幂符号后的数字
    //结尾的空格
    //
    //作者：Krahets
    //链接：https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solutions/278913/mian-shi-ti-20-biao-shi-shu-zhi-de-zi-fu-chuan-y-2/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static boolean isNumber(String s) {
        Map[] states = {
                new HashMap<Character, Integer>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
                new HashMap<Character, Integer>() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap<Character, Integer>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap<Character, Integer>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap<Character, Integer>() {{ put('d', 3); }},                                        // 4.
                new HashMap<Character, Integer>() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap<Character, Integer>() {{ put('d', 7); }},                                        // 6.
                new HashMap<Character, Integer>() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap<Character, Integer>() {{ put(' ', 8); }}                                         // 8.
        };
        int p = 0;
        char t;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') t = 'd';
            else if(c == '+' || c == '-') t = 's';
            else if(c == 'e' || c == 'E') t = 'e';
            else if(c == '.' || c == ' ') t = c;
            else t = '?';
            if(!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }




    public static void main(String[] args) {
       String ss =  "[\"+100\", \"5e2\", \"-123\", \"3.1416\", \"-1E-16\", \"0123\"]";

        List<String> strs = JSONArray.parseArray(ss, String.class);
        for (String str : strs) {
            System.out.println(isNumber(str));
        }

        String aa = "[\"12e\", \"1a3.14\", \"1.2.3\", \"+-5\", \"12e+5.4\"]";
        List<String> str2s = JSONArray.parseArray(aa, String.class);
        for (String str : str2s) {
            System.out.println(isNumber(str));
        }

    }
//
//    public static boolean isNumber(String s) {
//        if (s.contains("E")) {
//            String data = s.substring(s.indexOf("E") + 1);
//            return extracted(data);
//        } else if (s.contains("e")) {
//            String data = s.substring(s.indexOf("e") + 1);
//            return extracted(data);
//        }
//        int count = -1;
//        for (int i = 0; i < s.length(); i++) {
//            if (i == count + 1 && count != -1) {
//                return s.charAt(i) >= 48 && s.charAt(i) < 58;
//            }
//            if (" ".equals(s.charAt(i))) {
//                continue;
//            }
//            if (s.charAt(i) < 48 || s.charAt(i) >= 58) {
//                return false;
//            }
//            if (".".equals(s.charAt(i))) {
//                count = i;
//            }
//
//        }
//        return true;
//    }
//
//    private static boolean extracted(String data) {
//        for (int i = 0; i < data.length(); i++) {
//            if ("-".equals(data.charAt(i) + "") && i == 0) {
//                continue;
//            } else {
//                return data.charAt(i) >= 48 && data.charAt(i) < 58;
//            }
//        }
//       return false;
//    }
}
