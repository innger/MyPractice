package com.ryl.learn.puzzlers;

import java.util.Arrays;

public class Insertion {


    public static void main(String[] args) {
        int[] array = new int[]{10, 23, 1, 43, 54, 6, 76, 78};
//		insertSort(array);
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

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


}
