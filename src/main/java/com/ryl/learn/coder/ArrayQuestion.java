package com.ryl.learn.coder;

/**
 * Created on 16/9/22 上午9:58.
 */
public class ArrayQuestion {
	
	public static void main(String[] args) {
		System.out.println(turningNumberIndex(new int[]{1, 2, 3, 4, 5, 3}));
		System.out.println(turningNumberIndex(new int[]{1, 2, 3, 4, 7, 1}));
	}
	
	/**
	 * No. 22 - Turning Number in an Array
	 * 先递增再递减数组,单峰数组,找出峰值
	 * 二分查找
	 *
	 * @param numbers int[]
	 * @return index of largest num
	 */
	public static int turningNumberIndex(int[] numbers) {
		if (numbers == null || numbers.length <= 2) {
			return -1;
		}
		int left = 0;
		int right = numbers.length - 1;
		while (right > left + 1) {
			int mid = left + (right - left) / 2;
			if (mid == 0 || mid == numbers.length - 1) {
				return -1;
			}
			if (numbers[mid] > numbers[mid - 1] && numbers[mid] > numbers[mid + 1]) {
				return mid;
			} else if (numbers[mid] > numbers[mid - 1] && numbers[mid] < numbers[mid + 1]) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return -1;
	}
}
