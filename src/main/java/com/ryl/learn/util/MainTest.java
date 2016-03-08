package com.ryl.learn.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.*;

/**
 * Created by renyulong on 16/1/27.
 */
public class MainTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(UUID.randomUUID().toString());
            System.out.println(Integer.parseInt("b80cbec", 16));
        }

    }

    public static void testMap() {
        Map<String, Boolean> map = new HashMap<>();
        Boolean b = (map != null ? map.get("get") : false);
//        Boolean b = map.get("get");
        System.out.println(b);
    }


    public static void testint() { //15712189
        byte[] bytes = new byte[]{127, -17, -65, -67};
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.put(bytes, 0, 4);
        buffer.flip();
//        System.out.println(buffer.getInt());

        for (int i = 0; i <= Integer.MAX_VALUE; i++) {
            ByteBuffer b = ByteBuffer.allocate(4);
            b.putInt(i);
            if (!isValid(b.array())) {
                System.out.println("invalid " + i);
            }
        }
    }

    public static void maintest1() {

        byte[] bytes = new byte[]{0, 0, 0, 0, 0, -17, -65, -67};
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.put(bytes, 0, bytes.length);
        buffer.flip();
        System.out.println(buffer.getLong()); // 15712189

        buffer.putLong(0, 15712189);
        bytes = buffer.array();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }


        System.out.println("==================" + isValid(bytes));


        System.out.println(0x00efbfbd);


        System.out.println("".length());
        System.out.println((byte) 11);
        System.out.println("================");
        byte[] byteArr = "\uffff".getBytes();
        System.out.println(byteArr.length);
        for (byte b : byteArr) {
            System.out.println(b);
        }
        //random种子相同,重复执行产生的随机序列相同
        Random random = new Random(10000);
        for (int i = 0; i < 10; i++) {
//            System.out.println(random.nextInt(10000));
        }

        System.out.println("1".getBytes());
        System.out.println(0x00efbfbd);

        System.out.println(testDelimiter());

        try {
            System.out.println(Arrays.toString("\ufffd".getBytes("GBK")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    public static long testDelimiter() {
        for (; ; ) {
            //DA+项目中分包符号"\ufffd" 问题
            //对应的bytes数组 -17 -65 -67
            ByteBuffer buffer = ByteBuffer.allocate(8);
            int time = (int) (System.currentTimeMillis() / 1000);

            int count = 1;
            buffer.putInt(time);// 高位
            buffer.putInt(count);// 低位

            buffer.flip();
            long msgId = buffer.getLong();

            boolean valid = isValid(buffer.array());
            if (!valid) {
                continue;
            } else {
                return msgId;
            }
        }
    }

    public static boolean isValid(byte[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && i + 2 < arr.length) {
                if (arr[i] == -17 && arr[i + 1] == -65 && arr[i + 2] == -67) {
//                    System.out.println(arr);
                    return false;
                }
            }
        }
        return true;
    }
}
