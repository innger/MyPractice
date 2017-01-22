package com.ryl.learn.lecode;

/**
 * Easy code 003
 * Created on 17/1/22 09:48.
 */
public class EasyNew {
    
    public static void main(String[] args) {
        EasyNew easyNew = new EasyNew();
        System.out.println(easyNew.hammingDistance(1, 4));
        System.out.println(easyNew.hammingWeight(-1));
        
        System.out.println(easyNew.findComplement(1));
        
    }
    
    /**
     * 476. Number Complement
     * 求num的补码,翻转各位上的0和1
     * <p>
     * Note:
     * 1, The given integer is guaranteed to fit within the range of a 32-bit signed integer. 32位有符号数
     * 2, You could assume no leading zero bit in the integer’s binary representation.
     *
     * @param num int
     * @return int
     */
    public int findComplement(int num) {
        byte[] bits = new byte[32];
        int n = 32;
        //转换成二进制表示
        while (n > 0) {
            int i = (num >> (n - 1)) & 1;
            bits[32 - n] = ((byte) (i));
            n--;
        }
        boolean first = false;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (first || bits[i] == 1) {
                first = true;
                byte b = (byte) (bits[i] ^ 1);
                if (b == 1) {
                    res = res | (1 << (31 - i));
                }
            }
        }
        return res;
    }
    
    /**
     * 461. Hamming Distance
     * 计算两个整数的汉明码,各位二进制0,1不同的位数
     * 0 <= x,y < 2^31
     *
     * @param x int 1
     * @param y int 4
     * @return int 2
     */
    public int hammingDistance(int x, int y) {
        return hammingWeight(x ^ y);
    }
    
    private int hammingWeight(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n = (n - 1) & n;
        }
        return cnt;
    }
    
}
