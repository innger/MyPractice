package com.ryl.learn.lecode;

import java.util.*;

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
        System.out.println(easyNew.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
        
        System.out.println(easyNew.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(easyNew.findDisappearedNumbers(new int[]{1, 1}));
        
        int[][] grid = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(easyNew.islandPerimeter(grid));
        
        System.out.println(Arrays.toString(easyNew.constructRectangle(4)));
        
        System.out.println(easyNew.numberOfBoomerangs(new int[][]{
                {0, 0}, {1, 0}, {2, 0}
        }));

//        System.out.println(easyNew.repeatedSubstringPattern("abab"));
//        System.out.println(easyNew.repeatedSubstringPattern("aba"));
//        System.out.println(easyNew.repeatedSubstringPattern("abcabcabcabc"));
//        System.out.println(easyNew.repeatedSubstringPattern("bb"));
        System.out.println(easyNew.countSegments("     "));
        
        System.out.println(easyNew.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
    }
    
    /**
     * 475. Heaters 加热器
     * 房间和加热器在水平线上,求加热器的最小加热半径,使所有房间都保持温度
     * Input: [1,2,3],[2]  Output: 1
     * Input: [1,2,3,4],[1,4]  Output: 1
     * Binary Search
     * 房间和加热器个数不超过25000,位置不超过10^9
     *
     * @param houses  int[] 正整数
     * @param heaters int[]
     * @return int
     */
    public int findRadius(int[] houses, int[] heaters) {
        //每一个房间找离最近的加热器
        List<Position> list = new ArrayList<>();
        int radius = 0;
        //房间是-1,加热器是1
        for (int house : houses) {
            list.add(new Position(house, -1));
        }
        for (int heater : heaters) {
            list.add(new Position(heater, 1));
        }
        Collections.sort(list, new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                return o1.getNum() - o2.getNum();
            }
        });
        System.out.println(list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Position position = list.get(i);
            int num = position.getNum();
            if (position.getType() == -1) {
                //往前找
                int j = i;
                int tmpL = Integer.MAX_VALUE;
                while (j >= 0 && list.get(j).getType() != 1) j--;
                if (j >= 0) {
                    tmpL = num - list.get(j).getNum();
                }
                //往后找
                j = i;
                int tmpR = Integer.MAX_VALUE;
                while (j < size && list.get(j).getType() != 1) j++;
                if (j < size) {
                    tmpR = list.get(j).getNum() - num;
                }
                int tmp = Math.min(tmpL, tmpR);
                if (radius < tmp) radius = tmp;
            }
        }
        return radius;
    }
    
    static class Position {
        private int num;
        private int type; //-1房间,1加热器
        
        public Position(int num, int type) {
            this.num = num;
            this.type = type;
        }
        
        public int getNum() {
            return num;
        }
        
        public void setNum(int num) {
            this.num = num;
        }
        
        public int getType() {
            return type;
        }
        
        public void setType(int type) {
            this.type = type;
        }
        
        @Override
        public String toString() {
            return "Position{" +
                    "num=" + num +
                    ", type=" + type +
                    '}';
        }
    }
    
    
    /**
     * 434. Number of Segments in a String
     * 返回字符串中,段数 空格分割
     *
     * @param s string 不包含不可见字符
     * @return int
     */
    public int countSegments(String s) {
        if (s == null) return 0;
        s = s.trim();
        if (s.length() == 0) return 0;
        return s.split("\\s+").length;
    }
    
    /**
     * 459. Repeated Substring Pattern
     * 判断一个字符串是否是其一个子串的重复
     *
     * @param str String abab 只包含小写字符,长度不超过10000
     * @return boolean true
     */
    public boolean repeatedSubstringPattern(String str) {
        if (str == null || str.length() <= 1) return false;
        char first = str.charAt(0);
        if (str.replace(String.valueOf(first), "").equals("")) return true;
        StringBuilder sb = new StringBuilder().append(first);
        int len = str.length();
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == first && len % sb.length() == 0) {
                //len % sb.length() == 0 多一层条件判断,过滤不符合条件的,减少replace判断操作
                //去掉这个条件, time limit
                if (str.replace(sb, "").equals("")) {
                    return true;
                }
            }
            sb.append(str.charAt(i));
        }
        return false;
    }
    
    /**
     * 447. Number of Boomerangs
     * 平面中n个点,
     * a "boomerang" is a tuple of points (i, j, k)
     * i到j的距离 = i到k的距离
     * i j k 顺序相关
     * 求每个点到另外点的距离,距离相等的个数n,可组成boomerang的个数为 n*(n-1)
     *
     * @param points int[][] [[0,0],[1,0],[2,0]]
     * @return int 2 [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
     */
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int[] p2 = points[j];
                int dis = calDistance(p1, p2);
                Integer v = map.get(dis);
                if (v != null) {
                    map.put(dis, v + 1);
                } else {
                    map.put(dis, 1);
                }
            }
            for (Integer v : map.values()) {
                res += v * (v - 1);
            }
        }
        return res;
    }
    
    private int calDistance(int[] a, int[] b) {
        return (int) (Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }
    
    /**
     * 492. Construct the Rectangle
     * 给出面积,设计page web矩形的长宽
     * 面积=给出target area
     * L >= W.
     * L W 的大小尽量接近
     *
     * @param area int 正整数,不大于10,000,000
     * @return int[] 长宽是正整数 [L , W]
     */
    public int[] constructRectangle(int area) {
        int w = 1;
        int l = area;
        int[] res = new int[]{l, w};
        while (w <= l) {
            w++;
            if (area % w == 0) {
                l = area / w;
                if ((l - w) >= 0 && (l - w) < (res[0] - res[1])) {
                    res[0] = l;
                    res[1] = w;
                }
            }
        }
        return res;
    }
    
    /**
     * 463. Island Perimeter 求岛的周长
     * [[0,1,0,0],
     * [1,1,1,0],
     * [0,1,0,0],
     * [1,1,0,0]]
     * return 16, 两个1相邻,周长=2*4 - 2
     *
     * @param grid int[][]
     * @return int
     */
    public int islandPerimeter(int[][] grid) {
        //一共多少个1,有多少相邻
        int numberOf1 = 0;
        int neighbor = 0;
        int width = grid[0].length;
        int height = grid.length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int value = grid[i][j];
                if (value == 1) {
                    numberOf1++;
                    int x = i;
                    int y = j - 1;
                    if (y >= 0 && grid[x][y] == 1) neighbor++;
                    
                    x = i;
                    y = j + 1;
                    if (y < width && grid[x][y] == 1) neighbor++;
                    
                    x = i - 1;
                    y = j;
                    if (x >= 0 && grid[x][y] == 1) neighbor++;
                    
                    x = i + 1;
                    y = j;
                    if (x < height && grid[x][y] == 1) neighbor++;
                }
            }
        }
        return numberOf1 * 4 - neighbor;
    }
    
    static class Point {
        private int x;
        private int y;
        private int v;
        
        public Point(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
        
        public int getV() {
            return v;
        }
        
        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", v=" + v +
                    '}';
        }
    }
    
    /**
     * 455. Assign Cookies
     * 数组s与g对比,满足s中数字大于等于g中数字的最多个数
     *
     * @param g int[]
     * @param s int[]
     * @return int
     */
    public int findContentChildren(int[] g, int[] s) {
        // TODO: 17/1/23  
        return 1;
    }
    
    /**
     * 448. Find All Numbers Disappeared in an Array
     * 数组中某些数字出现两次,或者一次
     * 找出未在数组中出现的全部数字,数组中数字本身也是index
     * Input:
     * [4,3,2,7,8,2,3,1]
     * Output:
     * [5,6]
     *
     * @param nums int[] 1 ≤ a[i] ≤ n (n = size of array)
     * @return list Integer
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        int i = 0;
        while (i < len) {
            int n = nums[i];
            if (n == 0) {
                i++;
            } else {
                while (n != 0) {
                    int j = n - 1;
                    n = nums[j];
                    if (nums[j] == 0) {
                        i++;
                        break;
                    }
                    nums[j] = 0;
                }
            }
        }
        //数组中不为零数字index+1为缺失的数字
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < len; j++) {
            if (nums[j] != 0) {
                result.add(j + 1);
            }
        }
        return result;
    }
    
    /**
     * 485. Max Consecutive Ones
     * 给出一个二进制数组,里面是0,1,找出连续1组成的最大数
     * [1,1,0,1,1,1] return 3
     * 数组长度不超过10,000
     *
     * @param nums int[] binary array
     * @return int
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        //遍历一遍,找出最长连续1的个数
        int max = 0;
        int cur = 0;
        for (int n : nums) {
            if (n == 0) {
                max = cur > max ? cur : max;
                cur = 0;
            } else {
                cur++;
            }
        }
        return cur > max ? cur : max;
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
