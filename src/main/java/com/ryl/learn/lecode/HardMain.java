package com.ryl.learn.lecode;

import java.util.Arrays;

/**
 * hard problem 001
 * Created by renyulong on 16/2/3.
 */
public class HardMain {


    public static void main(String[] args) {
        HardMain main = new HardMain();
        System.out.println(main.maxProfit(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(main.maxProfitTimeLimit(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    /**
     *
     *
     * http://liangjiabin.com/blog/2015/04/leetcode-best-time-to-buy-and-sell-stock.html
     * @param prices int[]
     * @return max int
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[] preProfit = new int[len];
        int[] postProfit = new int[len];

        int curMin = prices[0];
        for (int i = 1; i < len; i++) {
            curMin = Math.min(curMin, prices[i]);
            preProfit[i] = Math.max(preProfit[i - 1], prices[i] - curMin);
        }

        int curMax = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            curMax = Math.max(curMax, prices[i]);
            postProfit[i] = Math.max(postProfit[i + 1], curMax - prices[i]);
        }
        System.out.println(Arrays.toString(preProfit));
        System.out.println(Arrays.toString(postProfit));
        int max = 0;
        for (int i = 0; i < preProfit.length; i++) {
            max = Math.max(max, preProfit[i] + postProfit[i]);
        }
        return max;
    }

    //wrong
    public int maxProfitTimeLimit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[] preProfit = new int[len];
        int[] postProfit = new int[len];

        for (int i = 0; i < len; i++) {
            preProfit[i] = subMaxProfit(prices, 0, i);
            postProfit[i] = subMaxProfit(prices, i, len);
        }
        System.out.println(Arrays.toString(preProfit));
        System.out.println(Arrays.toString(postProfit));
        int max = 0;
        for (int i = 0; i < preProfit.length; i++) {
            max = Math.max(max, preProfit[i] + postProfit[i]);
        }
        return max;
    }


    private int subMaxProfit(int[] prices, int m, int n) {
        int min = prices[m];
        int profit = 0;
        for (int i = m; i < n; i++) {
            int cur = prices[i] - min;
            if (cur > profit) {
                profit = cur;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return profit;
    }
}
