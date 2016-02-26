package com.ryl.learn.puzzlers;

import java.util.UUID;

public class Add {

    public static void main(String[] args) {
        System.out.println(AddWithoutArithmetic(123, 123));
        //groupName:groupUid;groupName:groupUid;groupName:groupUid;
        String[] group = "测试组1:cmsadmin;测试组1:cmsuser;测试组2:wpadmin;测试组2:zhaopeng;".split(";");
        for (String g : group) {
            String[] one = g.split(":");
            System.out.println(one[0] + one[1]);
        }
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }


    public static int AddWithoutArithmetic(int num1, int num2) {
        if (num2 == 0)
            return num1;

        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;

        return AddWithoutArithmetic(sum, carry);
    }
}
