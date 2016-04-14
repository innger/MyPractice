package com.ryl.learn.lecode;

import java.util.*;

/**
 * Created by renyulong on 16/2/3.
 */
public class MediumMain {

    public static void main(String[] args) {
        MediumMain main = new MediumMain();

        List<List<Integer>> input = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < 2; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                list.add(j, num);
                num++;
            }
            input.add(list);
        }
        System.out.println(input);

        System.out.println(main.minimumTotal2(input));

    }

    public int removeDuplicates(int[] nums) {


        return 1;
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n / 2; row++) {
            for (int col = row; col < n - row - 1; col++) {
                int top = matrix[row][col]; // back top
                //left->top
                matrix[row][col] = matrix[n - col - 1][row];
                //bottom->left
                matrix[n - col - 1][row] = matrix[n - row - 1][n - col - 1];
                //right->bottom
                matrix[n - row - 1][n - col - 1] = matrix[col][n - row - 1];
                //top->right
                matrix[col][n - row - 1] = top;
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return null;
    }


    //动态规划，从下往上走
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        if (m == 0) {
            return 0;
        }
        Integer[] dp = new Integer[triangle.get(m - 1).size()];
        triangle.get(m - 1).toArray(dp);
        for (int r = m - 2; r >= 0; r--) {
            for (int c = 0; c <= r; c++) {
                dp[c] = Math.min(dp[c], dp[c + 1]) + triangle.get(r).get(c);
            }
        }
        return dp[0];
    }

    //triangle数组可改变,直接在原数组上操作
    public int minimumTotal2(List<List<Integer>> triangle) {
        int m = triangle.size();
        if (m == 0) {
            return 0;
        }
        for (int r = m - 2; r >= 0; r--) {
            for (int c = 0; c <= r; c++) {
                int v1 = triangle.get(r + 1).get(c);
                int v2 = triangle.get(r + 1).get(c + 1);
                triangle.get(r).set(c, Math.min(v1, v2) + triangle.get(r).get(c));
            }
        }
        return triangle.get(0).get(0);
    }


    //Best Time to Buy and Sell Stock
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int cur = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > cur) {
                profit += prices[i] - cur;
            }
            cur = prices[i];
        }
        return profit;
    }

    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
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

    //双数组解法
    //http://blog.csdn.net/xudli/article/details/46911603
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        arr[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            arr[i] = arr[i + 1] * nums[i + 1];
        }
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[i] = arr[i] * left;
            left = left * nums[i];
        }
        return arr;
    }

    public int[] productExceptSelf1(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    arr[j] = arr[j] * nums[i];
                }
            }
        }
        return arr;
    }

    //Solve it without division and in O(n).
    public int[] productExceptSelf2(int[] nums) {
        int all = 1;
        for (int i = 0; i < nums.length; i++) {
            all = all * nums[i];
        }

        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = all / nums[i];
        }
        return arr;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        for (int i = 0; i <= nums.length - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j <= nums.length - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int p = j + 1;
                int q = nums.length - 1;
                while (p < q) {
                    int sum = nums[i] + nums[j] + nums[p] + nums[q];
                    if (sum < target) {
                        p++;
                    } else if (sum > target) {
                        q--;
                    } else {
                        List<Integer> tmpList = new ArrayList<Integer>();
                        tmpList.add(nums[i]);
                        tmpList.add(nums[j]);
                        tmpList.add(nums[p]);
                        tmpList.add(nums[q]);
                        list.add(tmpList);
                        p++;
                        q--;

                        while (p < q && nums[p] == nums[p - 1]) {
                            p++;
                        }
                        while (p < q && nums[q] == nums[q + 1]) {
                            q--;
                        }
                    }
                }
            }
        }

        return list;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            judgeAndPut(nums, i, i + 1, nums.length - 1, list);
        }
        return list;
    }

    private void judgeAndPut(int[] num, int i, int p, int q, List<List<Integer>> list) {
        while (p < q) {
            if (num[p] + num[q] + num[i] < 0) {
                p++;
            } else if (num[p] + num[q] + num[i] > 0) {
                q--;
            } else {
                List<Integer> tmpList = new ArrayList<Integer>();
                tmpList.add(num[i]);
                tmpList.add(num[p]);
                tmpList.add(num[q]);
                list.add(tmpList);
                p++;
                q--;
                while (p < q && num[p] == num[p - 1]) {
                    p++;
                }
                while (p < q && num[q] == num[q + 1]) {
                    q--;
                }
            }
        }
    }

    //
    private void judgeAndPutWrong(int[] num, int i, int p, int q, List<List<Integer>> list) {
        while (p < q) {
            if (num[p] + num[q] + num[i] < 0) {
                p++;
            } else if (num[p] + num[q] + num[i] > 0) {
                q--;
            } else {
                List<Integer> tmpList = new ArrayList<Integer>();
                tmpList.add(num[i]);
                tmpList.add(num[p]);
                tmpList.add(num[q]);
                list.add(tmpList);
                p++;
                q--;
            }
            // 参考blog里面把两个while循环写在外面了,自己调试了好久发现应该放在里面
            // 注意 p-1 和 q+1 的逻辑,循环中直接判重
            // 当想留言说有错时,发现博主写的是对的,是自己看的时候粗心搞错了,o(╯□╰)o
            while (p < q && num[p] == num[p - 1]) {
                p++;
            }
            while (p < q && num[q] == num[q + 1]) {
                q--;
            }
        }
    }

    //http://blog.csdn.net/li4951/article/details/8693212
    public List<List<Integer>> threeSumWrong(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {

                        int max = nums[i] > nums[j] ? nums[k] > nums[i] ? nums[k] : nums[i] : nums[k] > nums[j] ? nums[k] : nums[j];
                        int min = nums[i] < nums[j] ? nums[k] < nums[i] ? nums[k] : nums[i] : nums[k] < nums[j] ? nums[k] : nums[j];
                        int mid = 0 - max - min;

                        if (set.contains(min - mid - max)) {
                            break;
                        }

                        List<Integer> subList = new ArrayList<Integer>(3);
                        subList.add(min);
                        subList.add(mid);
                        subList.add(max);
                        res.add(subList);
                        break;
                    }
                }
            }
        }
        return res;
    }

    //http://blog.csdn.net/ljiabin/article/details/39968583
    public String int2Roman(int num) {
        String[][] roman = {{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}};
        String res = "";
        int digit = 0;
        while (num != 0) {
            int t = num % 10;
            res = roman[digit][t] + res;
            digit++;
            num /= 10;
        }
        return res;
    }

    //http://blog.csdn.net/havenoidea/article/details/11848921
    public String intToRoman(int num) {
        String str = "";
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; num != 0; i++) {
            while (num >= value[i]) {
                num -= value[i];
                str += symbol[i];
            }
        }
        return str;
    }

    //三层循环最原始的方法居然都AC
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int tmp = nums[i] + nums[j] + nums[k];
                    int newDiff = Math.abs(tmp - target);
                    if (newDiff < diff) {
                        diff = newDiff;
                        res = tmp;
                        if (res == target) {
                            return res;
                        }
                    }
                }
            }
        }
        return res;
    }

    public int threeSumClosestNew(int[] num, int target) {
        int closest = 0;
        boolean needInit = true;
        Arrays.sort(num); //排序从两头找
        for (int i = 0; i <= num.length - 3; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int p = i + 1;
            int q = num.length - 1;
            while (p < q) {
                int sum = num[i] + num[p] + num[q];
                if (needInit || Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                needInit = false;
                if (sum <= target) {
                    p++;
                    while (p < q && num[p] == num[p - 1]) {
                        p++;
                    }
                } else if (sum > target) {
                    q--;
                    while (p < q && num[q] == num[q + 1]) {
                        q--;
                    }
                }
            }
        }
        return closest;
    }


    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.get(tmp) != null) {
                res[0] = map.get(tmp) + 1;
                res[1] = i + 1;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    /**
     * 先排序,从两头查找,再循环原始数组找到索引 效率比较低
     * 不如上面用Hashmap的方式直接查询索引
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumUSort(int[] nums, int target) {
        int len = nums.length;
        int[] sorted = new int[len];
        System.arraycopy(nums, 0, sorted, 0, len);
        Arrays.sort(sorted);
        int i = 0;
        int j = len - 1;
        int p = 0;
        int q = 0;
        while (i < j) {
            p = sorted[i];
            q = sorted[j];
            if (p + q > target) {
                j--;
            } else if (p + q < target) {
                i++;
            } else {
                break;
            }
        }
        int[] res = new int[]{-1, -1};
        for (int n = 0; n < len; n++) {
            if (nums[n] == p && res[0] == -1) {
                res[0] = n;
            } else if (nums[n] == q && res[1] == -1) {
                res[1] = n;
            }
        }

        return res;
    }
}
