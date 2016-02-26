package com.ryl.learn.puzzlers;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


public class ClazzLoaderTest {

    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());

        Map<String, String> m = new HashMap<String, String>();
        m.put(null, null);
        System.out.println(m.get(null));

        Hashtable<String, String> table = new Hashtable<String, String>();
        table.put("123", "hello"); //table 里面不能null 作为key value
        System.out.println(table.get("123"));

        String a = "";
        String[] arr = a.split(",");
        System.out.println(arr.length);
        for (String str : arr) {
            System.out.println("-" + str);
        }
    }

}
