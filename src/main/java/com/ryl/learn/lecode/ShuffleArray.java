package com.ryl.learn.lecode;


import java.util.Arrays;
import java.util.Random;

/**
 * Created on 16/8/15 上午11:57.
 * 384. Shuffle an Array
 * <p>
 * Shuffle a set of numbers without duplicates.
 */
public class ShuffleArray {

    private final int[] orignal;
    private int[] array;

    public ShuffleArray(int[] nums) {
        int len = nums.length;
        orignal = Arrays.copyOf(nums, len);
        array = Arrays.copyOf(nums, len);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return orignal;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int size = array.length;
        Random rnd = new Random();
        // Shuffle array
        for (int i = size; i > 1; i--)
            swap(array, i - 1, rnd.nextInt(i));
        return array;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
