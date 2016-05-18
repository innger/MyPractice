package com.ryl.learn.jdk8.interfaces;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created on 16/5/18 上午11:10.
 */
public class Lambda {

    public static void main(String[] args) {
        sort();
    }

    public static void sort() {

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println("before: " + names);
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        //已知变量类型可省略
        Collections.sort(names, (a, b) -> b.compareTo(a));

        //even shorter
        names.sort((a, b) -> b.compareTo(a));

        System.out.println("after: " + names);


    }

}
