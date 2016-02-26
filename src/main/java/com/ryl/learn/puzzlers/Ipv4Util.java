package com.ryl.learn.puzzlers;

import java.net.InetAddress;
import java.util.Arrays;

public class Ipv4Util {

    private final static int INADDRSZ = 4;

    public static byte[] ipToBytesByInet(String ipAddr) {
        try {
            return InetAddress.getByName(ipAddr).getAddress();
        } catch (Exception e) {
            throw new IllegalArgumentException(ipAddr + " is invalid IP!");
        }
    }

    public static byte[] ipToBytesByReg(String ipAddr) {
        byte[] ret = new byte[4];
        try {
            String[] ipArr = ipAddr.split("\\.");
            ret[0] = (byte) (Integer.parseInt(ipArr[0]) & 0xFF);
            ret[1] = (byte) (Integer.parseInt(ipArr[1]) & 0xFF);
            ret[2] = (byte) (Integer.parseInt(ipArr[2]) & 0xFF);
            ret[3] = (byte) (Integer.parseInt(ipArr[3]) & 0xFF);
            return ret;
        } catch (Exception e) {
            throw new IllegalArgumentException(ipAddr + " is invalid IP!");
        }
    }

    public static String bytesToIp(byte[] bytes) {
        return new StringBuffer().append(bytes[0] & 0xFF).append('.').append(bytes[1] & 0xFF).append('.').
                append(bytes[2] & 0xFF).append('.').append(bytes[3] & 0xFF).append('.').toString();
    }

    public static int bytesToInt(byte[] bytes) {
        int addr = bytes[3] & 0xFF;
        addr |= ((bytes[2] << 8) & 0xFF00);
        addr |= ((bytes[1] << 16) & 0xFF0000);
        addr |= ((bytes[0] << 24) & 0xFF000000);
        return addr;
    }

    public static int ipToInt(String ipAddr) {
        try {
            return bytesToInt(ipToBytesByInet(ipAddr));
        } catch (Exception e) {
            throw new IllegalArgumentException(ipAddr + " is invalid ip");
        }
    }

    public static byte[] intToBytes(int ipInt) {
        byte[] ipAddr = new byte[INADDRSZ];
        ipAddr[0] = (byte) ((ipInt >>> 24) & 0xFF);
        ipAddr[1] = (byte) ((ipInt >>> 16) & 0xFF);
        ipAddr[2] = (byte) ((ipInt >>> 8) & 0xFF);
        ipAddr[3] = (byte) (ipInt & 0xFF);
        return ipAddr;
    }

    public static String intToIp(int ipInt) {
        return new StringBuffer().append((ipInt >> 24) & 0xFF).append('.').append((ipInt >> 16) & 0xFF).append('.').
                append((ipInt >> 8) & 0xFF).append('.').
                append((ipInt) & 0xFF).toString();
    }

    public static char selectTheFirstSingle(String str) {
        int[] arr = new int[256];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)] += 1;
        }

        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i)] == 1)
                return str.charAt(i);
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(selectTheFirstSingle("abcdfeabcac"));
        System.out.println(intToIp(ipToInt("172.17.2.156")));
        System.out.println(Arrays.toString(ipToBytesByInet("172.17.2.156")));
        System.out.println(Arrays.toString(ipToBytesByReg("172.17.2.156")));
    }

}
