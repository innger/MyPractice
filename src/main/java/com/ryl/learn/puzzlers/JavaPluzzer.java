package com.ryl.learn.puzzlers;

public class JavaPluzzer {
    public static void main(String[] args) {
        System.out.println(isOdd(-11));
        System.out.println(-11 % -2); //(a/b)*b+a%b == a
        System.out.println(2.00 - 1.10);
        final long micro = 24 * 60 * 60 * 1000 * 1000;
        final long milli = 24 * 60 * 60 * 1000;
        System.out.println(micro / milli);
        System.out.println(12345 + 5432l);//5432L
        System.out.println(Long.toHexString(0x100000000L + 0xcafebabe));

        char x = 'X';
        int i = 0;
        System.out.println(true ? x : 0);
        System.out.println(false ? i : x);

        short m = 1;
        short n = 2;
//		m =  (m+n);
        m += n;

        Object buy = "buy";
        String java = "effective java";
        buy = buy + java;
//		buy+= java;
        System.out.println((int) (char) (byte) -1);

        System.out.println("2+2=" + (2 + 2));
    }

    //判断是够为奇数
    private static boolean isOdd(int i) {
//		return i%2 == 1;
//		return i%2 !=0;
        return (i & 1) == 1;
    }
}
