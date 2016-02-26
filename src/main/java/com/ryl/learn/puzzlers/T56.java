package com.ryl.learn.puzzlers;

import java.math.BigInteger;

public class T56 {
    public static void main(String[] args) {
        BigInteger fiveThousand = new BigInteger("5000");
        BigInteger fiftyThousand = new BigInteger("50000");
        BigInteger fiveHundredThousand = new BigInteger("500000");

        BigInteger total = BigInteger.ZERO;
        total = total.add(fiveThousand);
        total = total.add(fiftyThousand);
        total = total.add(fiveHundredThousand);
        System.out.println(total);
        System.out.println(null instanceof T56); //null instanceof 任何类型都是false
    }
}
