package com.ryl.learn.puzzlers;

import java.util.Arrays;
import java.util.Properties;


public class JavaD {
    public static void main(String[] args) {
        Properties props = System.getProperties();
        //props.list(System.out);
        String userString = "~!@#$%\"^&**((&";
        System.out.println(isMatch(userString));
        System.out.println(new Object());
        String s = "ja";
        String s1 = s + "va";
        String s2 = "java";
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
        System.out.println("ja" + "va" == "java");
        int x = 8, y = 2, z;
        x = ++x * y;
        z = x / y++;
        System.out.println(x + " " + y + " " + z); //18 3 9
        int i = 1;
        i = i++;
        System.out.println(i);

        int a = 0, c = 0;
        do {
            c--;
            a = a - 1;
        } while (a > 0);
        System.out.println(c);
        System.out.println(Arrays.toString("|DF|A".split("|")));

        short num1 = 1;
        short num2 = 2;
        num1 = (short) (num1 + num2);
        num1 += num2;
        System.out.println("");

        Integer ia = new Integer(12);
        Integer ib = new Integer(12);
        System.out.println(ia == (ib + 0));

    }

    private static boolean isMatch(String password) {
        if (password.matches("^.{1,29}$")) {
            //匹配 数字 | 字母 | 非字母
            if (password.matches("^[\\W+[a-zA-z0-9]+]+$")) {
                if (password.matches("^[0-9]+$")) {
                    return false;
                }
                if (password.matches("^[a-zA-z]+$")) {
                    return false;
                }
                if (password.matches("^\\W+$")) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}	
