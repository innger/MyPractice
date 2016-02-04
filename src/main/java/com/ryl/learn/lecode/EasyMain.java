package com.ryl.learn.lecode;

import java.util.*;

/**
 * Created by renyulong on 16/1/25.
 * 练习思维,预防秀逗,并不是为了什么目的
 * 就跟跑步一样,不为愉悦别人,只为讨好自己
 */
public class EasyMain {

    public static void main(String[] args) {
        EasyMain easy = new EasyMain();
        System.out.println(easy.myAtoi("    10"));

    }

    public int myAtoi(String str) {
        try {
            for (int i = 0; i < str.length(); i++) {

            }
            return Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
    }


    public int majorityElement(int[] nums) {
        int m = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == m) {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt <= 0) {
                m = nums[i];
                cnt = 1;
            }
        }
        return m;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmpArr = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                tmpArr[k++] = nums1[i++];
            } else {
                tmpArr[k++] = nums2[j++];
            }
        }

        while (i < m) {
            tmpArr[k++] = nums1[i++];
        }
        while (j < n) {
            tmpArr[k++] = nums2[j++];
        }
        System.arraycopy(tmpArr, 0, nums1, 0, m + n);

    }


    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 0) {
                boolean flag = true;
                for (int j = i; j < nums.length - 1; j++) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    if (nums[j] == 0 && nums[j + 1] == 0) {
                        flag = flag && true;
                    } else {
                        flag = flag && false;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) return new ArrayList<Integer>();
        List<List<Integer>> list = generate(rowIndex + 1);
        return list.get(rowIndex);
    }


    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> list = new ArrayList<List<Integer>>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> subList = new ArrayList<Integer>(i + 1);
            if (i - 1 >= 0) {
                List<Integer> tmpList = list.get(i - 1);
                for (int j = -1; j < tmpList.size(); j++) {
                    int m = 0;
                    int n = 0;
                    if (j < 0)
                        m = 0;
                    else
                        m = tmpList.get(j);
                    if (j + 1 == tmpList.size())
                        n = 0;
                    else
                        n = tmpList.get(j + 1);
                    subList.add(m + n);
                }
            } else {
                subList.add(1);
            }
            list.add(subList);
        }
        return list;
    }


    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] res;
        int flag = 1;
        int i = len - 1;
        boolean is = false;
        for (; i >= 0; i--) {
            int tmp = digits[i] + flag;
            if (tmp < 10) {
                digits[i] = tmp;
                is = true;
                break;
            } else {
                flag = 1;
                digits[i] = tmp - 10;
            }
        }
        if (i > 0 || (i == 0 && is)) {
            res = new int[len];
            System.arraycopy(digits, 0, res, 0, len);
        } else {
            res = new int[len + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, len);
        }
        return res;
    }


    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int i = 0;
        int j = 1;
        while (i < nums.length && j < nums.length) {
            if (nums[i] == nums[j]) {
                len--;
            } else {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return len;
    }


    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i = 0;
        int j = len - 1;
        while (i <= j) {
            if (nums[i] == val) {
                len--;
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }
        return len;
    }


    public int reverse(int x) {
        String tmp = String.valueOf(x);
        String prefix = null;
        String res = "";
        for (int i = 0; i < tmp.length(); i++) {
            char c = tmp.charAt(i);
            if (c >= '0' && c <= '9') {
                res = c + res;
            } else {
                prefix = String.valueOf(c);
            }
        }
        if (prefix != null) {
            res = prefix + res;
        }
        try {
            return Integer.parseInt(res);
        } catch (Exception e) {
            return 0;
        }

    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[k - i - 1] = nums[nums.length - 1 - i];
        }
        for (int i = nums.length - 1 - k, j = nums.length - 1; i >= 0; i--, j--) {
            nums[j] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = arr[i];
        }
        printArray(nums);

    }

    private void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if (nums == null || nums.length < 1) {
            return res;
        }
        if (nums.length == 1) {
            res.add(nums[0] + "");
            return res;
        }

        int i = 0;
        int j = i + 1;
        while (i < nums.length && j <= nums.length) {
            if (j < nums.length && nums[j - 1] + 1 == nums[j]) {
                j++;
            } else {
                if (j - i > 1) {
                    res.add(nums[i] + "->" + nums[j - 1]);
                } else {
                    res.add(nums[j - 1] + "");
                }
                i = j;
                j = i + 1;
            }
        }
        return res;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            if (map.get(t) != null) {
                if (i - map.get(t) <= k) {
                    return true;
                }
            }
            map.put(t, i);
        }
        return false;


    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
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

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        List<Integer> sList = new ArrayList<Integer>(s.length());
        List<Integer> tList = new ArrayList<Integer>(t.length());
        for (int i = 0; i < s.length(); i++) {
            sList.add(s.indexOf(s.charAt(i)));
            tList.add(t.indexOf(t.charAt(i)));
        }
        System.out.println(sList);
        System.out.println(tList);
        for (int i = 0; i < s.length(); i++) {
            if (sList.get(i) != tList.get(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char a = s.charAt(i);
            if ((a >= '0' && a <= '9') || (a >= 'A' && a <= 'Z') || (a >= 'a' && a <= 'z')) {

            } else {
                i++;
                continue;
            }

            char b = s.charAt(j);
            if ((b >= '0' && b <= '9') || (b >= 'A' && b <= 'Z' || (b >= 'a') && b <= 'z')) {

            } else {
                j--;
                continue;
            }

            if (a >= '0' && a <= '9') {
                if (a != b) {
                    return false;
                } else {
                    i++;
                    j--;
                    continue;
                }

            } else {
                if (a == b || (a + 32) == b || (a - 32) == b) {
                    i++;
                    j--;
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty()) return false;
                    char tmpc = stack.pop();
                    if (tmpc == '(' && c == ')' || tmpc == '[' && c == ']' || tmpc == '{' && c == '}') {
                        continue;
                    } else {
                        return false;
                    }
                default:
                    return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;

    }

    /**
     * a   e   i
     * b d f h j
     * c   g   k
     *
     * @param str
     * @param n
     * @return
     */

    public String zigZag(String str, int n) {
        if (n == 1) {
            return str;
        }

        int x = 0, y = 0;
        int step = 2 * (n - 1);
        boolean s2 = false;
        int max = str.length();
        char[][] matrix = new char[max][n];

        for (int i = 0; i < str.length(); i++) {
            int k = i % step;
            if (k < n) {
                if (s2) {
                    s2 = false;
                    x++;
                    y--;
                }
                System.out.println("-----" + x + "," + y);
                matrix[x][y] = str.charAt(i);
                if (y < n - 1) {
                    y++;
                } else {
                    s2 = true;
                }
            } else {
                y--;
                x++;
                System.out.println("+++++" + x + "," + y);
                matrix[x][y] = str.charAt(i);
                s2 = true;
            }
        }
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < max; j++) {
                char c = matrix[j][i];
                if (c != 0) {
                    res += c;
                }
            }
        }
        return res;

    }
}
