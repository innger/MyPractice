package com.ryl.learn.puzzlers;

/**
 * 八皇后问题
 */
public class BaHuanghou {

    private static boolean[][] hh = new boolean[8][8];//8*8棋盘
    private static int count = 0;//已经放上的皇后数
    private static int num = 0;//摆放方式的总数

    public boolean condition1(int line) {//条件一，判断此列是否有摆放皇后
        for (int i = 0; i < 8; i++) {
            if (hh[i][line] == true) {
                return false;
            }
        }
        return true;
    }

    public boolean condition2(int k, int m) {//条件二，判断对角线是否有摆放皇后
        int i, j;
        for (i = k, j = m; i < 8 && j < 8; i++, j++) {
            if (hh[i][j] == true) {
                return false;
            }
        }
        for (i = k, j = m; i >= 0 && j >= 0; i--, j--) {
            if (hh[i][j] == true) {
                return false;
            }
        }
        for (i = k, j = m; i >= 0 && j < 8; i--, j++) {
            if (hh[i][j] == true) {
                return false;
            }
        }
        for (i = k, j = m; i < 8 && j >= 0; i++, j--) {
            if (hh[i][j] == true) {
                return false;
            }
        }
        return true;
    }

    //主要的递归实现方法  
    public void make(int line) {
        if (line == 8) return;//超过8行则退出
        for (int i = 0; i < 8; i++) {
            if (condition1(i) && condition2(line, i)) {
                hh[line][i] = true;
                count++;
                if (count == 8) {
                    System.out.println("\r\n");
                    print();//摆放皇后8个则打印结果  
                    hh[line][i] = false;//再次寻找其他情况
                    count--;
                    continue;
                }
                make(line + 1);//递归
                hh[line][i] = false;
                count--;
            }
        }
        return;
    }

    public void print() {//打印满足条件的摆放方法
        num++;
        System.out.println("<<<<<<<<<<" + num + ">>>>>>>>>>>>>>>");
        for (int i = 0; i < 8; i++) {
            System.out.println();
            for (int j = 0; j < 8; j++) {
                if (hh[i][j] == true) {
                    System.out.print("◆ ");
                } else {
                    System.out.print("○ ");
                }
            }
        }
    }

    public static void main(String[] args) {
        new BaHuanghou().make(0);
        System.out.println("\r\n\r\nnum = " + num);
    }


}
