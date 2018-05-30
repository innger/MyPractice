package com.ryl.learn.coder;

import org.junit.Test;

import java.util.*;

/**
 * Created on 16/9/22 上午9:58.
 */
public class ArrayQuestion {
	
	@Test
    public void turingNumberIndexTest() {
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
    
	@Test
    public void maxArrayTest() {
        System.out.println(Arrays.toString(getMaxArray(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3)));
    }
	
    /**
     * http://wiki.jikexueyuan.com/project/for-offer/question-sixty-five.html
     * 滑动窗口的最大值
     * 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
     * 
     * @param arr int[]
     * @param m int 窗口大小
     * @return max array
     */
	public int[] getMaxArray(int[] arr, int m) {
	    if (arr == null || arr.length < 1) {
	        return null;
        }
        int len = arr.length;
	    int resLen = len - m + 1;
	    if (resLen <= 1) {
	        int max = arr[0];
	        for (int i = 0; i < len; i++) {
	            max = arr[i] > max? arr[i] : max;
            }
            return new int[max];
        }
	    int[] res = new int[len - m + 1];
        int maxIndex = 0;
	    int max = arr[maxIndex];
        Deque<Integer> list = new LinkedList<>();
        int i = 0;
	    for(; i < m; i++) {
	        if (arr[i] > max) {
	            max = arr[i];
	            maxIndex = i;
            }
        }
	    int resIndex = 0;
	    list.addLast(maxIndex);
	    for(; i < len; i++) {
	        // 第一个窗口的最大值保存
	        res[resIndex++] = arr[list.getFirst()];
            // 如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
	        while(!list.isEmpty() && arr[i] >= arr[list.getLast()]) {
	            list.removeLast();
            }
            // 删除已经滑出窗口的数据对应的下标
	        if (!list.isEmpty() && list.getFirst() < i - m + 1) {
	            list.removeFirst();
            }
            System.out.println(list);
            list.addLast(i);
        }
        //最后一个窗口最大值入队
        res[resIndex] = arr[list.getFirst()];
	    return res;
    }
	
    /**
     * m区间长度,窗口沿着数组移动,输出每次窗口中最小值组成的数组
     *
     * @param arr int[]
     * @param m   区间长度
     * @return int[] 最小值组成的数组
     */
    public int[] getMinArray(int[] arr, int m) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        if (m >= arr.length) {
            //窗口不移动,及arr中的最小值
            int min = Integer.MAX_VALUE;
            for (int num : arr) {
                if (min > num) {
                    min = num;
                }
            }
            return new int[]{min};
        }
        int[] res = new int[arr.length - m + 1];
        int resi = 0;
        int i = 0;
        int j = m - 1;
        //使用TreeMap排序
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(); //按照key排序
        while (j < arr.length) {
            if (i == 0) {
                for (int n = i; n <= j; n++) {
                    fillTreeMap(map, arr[n]);
                }
                res[resi] = map.firstKey();
            } else {
                removeTreeMap(map, arr[i - 1]);
                fillTreeMap(map, arr[j]);
                res[resi] = map.firstKey();
            }
            i++;
            j++;
            resi++;
        }
        return res;
    }
    
    private void fillTreeMap(Map<Integer, Integer> map, int n) {
        Integer count = map.get(n);
        if (count == null) {
            map.put(n, 1);
        } else {
            map.put(n, count + 1);
        }
    }
    
    private void removeTreeMap(Map<Integer, Integer> map, int n) {
        Integer count = map.get(n);
        if (count <= 1) {
            map.remove(n);
        } else {
            map.put(n, count - 1);
        }
    }
	
}
