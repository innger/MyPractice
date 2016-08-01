package com.ryl.learn.lecode;

import java.util.Arrays;

/**
 * Created on 16/7/29 下午3:51.
 */
public class MediumImpl {


    public static void main(String[] args) {
        MediumImpl impl = new MediumImpl();
        int c = impl.coinChange(new int[]{1, 2, 4}, 11);
        System.out.println(c);
    }

    /**
     * 322. Coin Change
     * Write a function to compute the fewest number of coins that you need to make up that amount.
     * If that amount of money cannot be made up by any combination of the coins, return -1.
     * 使用最少的硬币个数,凑齐amount coins为硬币的面额
     *
     * @param coins  int[]
     * @param amount int
     * @return int
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        coinCount(amount, coins.length - 1, coins, 0);
        return total == Integer.MAX_VALUE ? -1 : total;
    }

    private int total = Integer.MAX_VALUE;

    private void coinCount(int amount, int index, int[] coins, int count) {
        if (index < 0 || count >= total - 1) return;
        int c = amount / coins[index];
        for (int i = c; i >= 0; i--) {
            int newCount = count + i;
            int rem = amount - i * coins[index];
            if (rem > 0 && newCount < total) {
                coinCount(rem, index - 1, coins, newCount);
            } else if (newCount < total) {
                total = newCount;
            } else if (newCount >= total - 1) {
                break;
            }
        }
    }

}
