package com.gui.recursion;

public class EightQueen {
    public static final int size = 8;
    public int[] place = new int[size];//第n行皇后所占位置的列号
    public int[] flag = {1, 1, 1, 1, 1, 1, 1, 1};//表示col列上是否可以放皇后，1可，0不可
    public int[] up = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};//表示主对角线是否可以放皇后，1可，0不可
    public int[] down = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};//表示副对角线是否可以放皇后，1可，0不可
    public int count = 0;//统计解的个数
    public static int number = 0;//统计递归次数

    public static void main(String[] args) {
        EightQueen eq = new EightQueen();
        eq.generate(0);
        System.out.println("递归次数: "+number);
    }

    public void generate(int n) {   //n表示第几个皇后
        number++;
        int col;
        for (col = 0; col < 8; col++) {  //列
            if (flag[col] == 1 && up[n - col + size - 1] == 1 && down[n + col] == 1) {
                place[n] = col;    //第n个皇后放在了第col列
                flag[col] = 0;     //把列占据
                up[n - col + size - 1] = 0;      //主对角线占据
                down[n + col] = 0;               //副对角线占据
                if (n < (size - 1)) {            //判断是否八个皇后都放置好，没有的话继续放置
                    generate(n + 1);
                } else {                         //放置好了的话打印放置方法
                    print();
                }
                //接着探索其他放法，删除皇后，取消占用列、主副对角线
                flag[col] = 1;
                up[n - col + size - 1] = 1;
                down[n + col] = 1;
            }
        }

    }

    public void print() {
        count++;
        System.out.printf("No.%d\n", count);
        int[][] table = new int[8][8];
        for (int i = 0; i < 8; i++) {
            table[i][place[i]] = 1;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }
    }
}
