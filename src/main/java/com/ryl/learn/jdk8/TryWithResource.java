package com.ryl.learn.jdk8;

import java.io.FileInputStream;

/**
 * Created on 16/3/15 上午10:52.
 */
public class TryWithResource {

    public static void main(String[] args) {

    }

    //实现java.lang.AutoClosable接口,可以在 try-with-resource语句块中使用
    private void tryWithResource() throws Exception {
        try (FileInputStream fis = new FileInputStream("~/test.log")) {
            int data = 0;
            while ((data = fis.read()) != -1) {
                System.out.println((char) data);
            }
        }
    }

}
