package com.xiaocaicai.dynamic;
// LCR 126. 斐波那契数
public class Offer126 {

    public static void main(String[] args) {
        Offer126 offer_126 = new Offer126();
        int fib = offer_126.fib(4);
        System.out.println();
    }


        public int fib(int n) {
            int a = 0;
            int b = 1;
            int c = a + b;
            if (n < 2) {
                return n;
            }

            for (int i = 2; i <= n; i++) {
                c = a + b;
                c = c >= 1000000007 ? c % 1000000007 : c;
                a = b;
                b = c;
            }

            return c;
        }

}
