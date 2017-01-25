package com.ryl.learn.util;

import com.google.common.base.Charsets;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MainTest
 * Created by renyulong on 16/1/27.
 */
public class MainTest {
    
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        String str = "renyulong";
        for (int i = 0; i < 1000000; i++) {
            if (str.toUpperCase().equals("RENYULONG")) {
                
            }
        }
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        str = str.toUpperCase();
        for (int i = 0; i < 1000000; i++) {
            if (str.equals("RENYULONG")) {
            }
        }
        System.out.println(System.currentTimeMillis() - start);
        
        int numPartitions = 3;
        for (int i = 0; i < 100; i++) {
            String key = RandomStringUtils.randomAlphanumeric(24);
            System.out.println(key + " " + Math.abs(key.hashCode()) % numPartitions);
            System.out.println("==============");
        }
        
        System.out.println(Math.abs("C81F662B8ADDC81F662B8ADD".hashCode() % numPartitions));
        
        System.out.println(Math.abs(Integer.MIN_VALUE) % numPartitions);
        System.out.println("polygenelubricants".hashCode());
        System.out.println(hash("polygenelubricants"));
        System.out.println(1 >>> 16);
        
        System.out.println(randomString(-229985452) + ' ' + randomString(-147909649));
        System.out.println(RandomStringUtils.randomAlphanumeric(32).toUpperCase());
        System.out.println(RandomStringUtils.randomAlphanumeric(16));
        
        String res = "";
        long s = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            res += "abc";
        }
        System.out.println(System.currentTimeMillis() - s);
        s = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("acd");
        }
        System.out.println(System.currentTimeMillis() - s);
    }
    
    /**
     * hello world
     *
     * @param seed int
     * @return string
     */
    public static String randomString(int seed) {
        Random rand = new Random(seed);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; ; i++) {
            int n = rand.nextInt(27);
            if (n == 0) break;
            sb.append((char) ('`' + n));
        }
        return sb.toString();
    }
    
    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    
    public static void commonTest() throws UnsupportedEncodingException {
        for (int i = 0; i < 10; i++) {
            System.out.println(UUID.randomUUID().toString());
            System.out.println(Integer.parseInt("b80cbec", 16));
        }
        
        System.out.println(getServerIp());
        
        String[] arr = "182.92.253.18".split(",");
        
        System.out.println(arr[0]);
        
        System.out.println(Charsets.UTF_8.displayName(Locale.TRADITIONAL_CHINESE));
        System.out.println("京A456221".substring(0, 2));
        for (int i = 0; i < 1; i++) {
            Integer msgId = new Random().nextInt(65535);
            int msgId2 = RandomUtils.nextInt(1, 65535);
            System.out.println(msgId + msgId2);
        }
        
        String str = "androidauto://openFeature?featureName=openUrl&createTime=2016-07-05 14:03:11&actionUrl=http%3A%2F%2Fwww.baidu.com%3Fa%3D1%26a%3Dv&sourceApplication=amap";
        Pattern pattern = Pattern.compile("actionUrl=(.*?)(&|$)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println(URLDecoder.decode(matcher.group(1), "UTF-8"));
        }
        String url = "http://www.baidu.com?a=1&a=v";
        System.out.println(URLEncoder.encode(url, Charsets.UTF_8.name()));
        
        //bigdecimal 四舍五入
        BigDecimal decimal = new BigDecimal(12.005);
        System.out.println(decimal.setScale(0, BigDecimal.ROUND_HALF_UP));
        
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        
        String[] strings = new String[]{"a", "b", "c"};
        strings = new String[0];
        System.out.println(Arrays.toString(Arrays.copyOf(strings, strings.length)));
    }
    
    public static String getServerIp() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address.getHostName() + StringUtils.LF + address.getHostAddress());
            return address.getHostAddress();
        } catch (UnknownHostException e) {
            return "-";
        }
    }
    
    public static void testMap() {
        Map<String, Boolean> map = new HashMap<>();
//        Boolean b = (map != null ? map.get("get") : false);
        Boolean b = map.get("get");
        System.out.println(b);
    }
    
    
    public static void testint() { //15712189
        byte[] bytes = new byte[]{127, -17, -65, -67};
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.put(bytes, 0, 4);
        buffer.flip();
        System.out.println(buffer.getInt());
        
        for (int i = 0; i <= Integer.MAX_VALUE - 300; i++) {
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
        for (byte b : bytes) {
            System.out.println(b);
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
            System.out.println(random.nextInt(10000));
        }
        
        System.out.println(Arrays.toString("1".getBytes()));
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
            if (valid) {
                return msgId;
            }
        }
    }
    
    public static boolean isValid(byte[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && i + 2 < arr.length) {
                if (arr[i] == -17 && arr[i + 1] == -65 && arr[i + 2] == -67) {
                    System.out.println(arr);
                    return false;
                }
            }
        }
        return true;
    }
}
