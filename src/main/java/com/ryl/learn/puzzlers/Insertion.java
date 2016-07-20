package com.ryl.learn.puzzlers;

import java.util.Arrays;

public class Insertion {


    public static void main(String[] args) {
        int[] array = new int[]{10, 23, 1, 43, 54, 6, 76, 78};
//		insertSort(array);
        shellSort(array);
        System.out.println(Arrays.toString(array));
        quicksort(0,6);
        System.out.println(Arrays.toString(x));
    }

    /**
     * 插入排序
     * @param array int[]
     */
    private static void insertSort(int[] array) {
        int j;
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            for (j = i; j > 0 && tmp < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = tmp;
        }
    }

    /**
     * 希尔排序
     * @param a int[]
     */
    private static void shellSort(int[] a) {
        int j;
        for (int gap = a.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < a.length; i++) {
                int tmp = a[i];
                for (j = i; j >= gap && tmp < a[j - gap]; j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }
        }
    }

    private static int[] x = new int[]{1,32,45,3,12,100,50};

    private static void quicksort(int l, int u){
        int i, m;
        if(l >= u) return;
        m = l;
        for(i = l+1; i<= u; i++)
            if(x[i] < x[l]) // buggy!
                swap(++m, i);

        swap(l, m);

        quicksort(l, m-1);
        quicksort(m+1, u);
    }

    private static void swap(int i ,int j) {
        int tmp = x[i];
        x[i] = x[j];
        x[j] = tmp;
    }


}
