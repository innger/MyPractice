package com.ryl.learn.puzzlers;

public class Add {

    public static void main(String[] args) {
        System.out.println(addWithoutArithmetic(123, 123));
    }

    /**
     * 不使用四则运算做加法
     * @param num1 int
     * @param num2 int
     * @return sum of num1 and num2
     */
    public static int addWithoutArithmetic(int num1, int num2) {
        if (num2 == 0)
            return num1;

        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;

        return addWithoutArithmetic(sum, carry);
    }
}
