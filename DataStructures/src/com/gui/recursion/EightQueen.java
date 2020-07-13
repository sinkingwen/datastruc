package com.gui.recursion;

public class EightQueen {
    public static final int size = 8;
    public int[] place = new int[size];
    public int[] flag = {1, 1, 1, 1, 1, 1, 1, 1};
    public int[] up = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    public int[] down = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    public int count = 0;

    public void main(String[] args) {
        EightQueen eq = new EightQueen();
        eq.generate(0);
    }

    public void generate(int n) {
        int col;
        for (col = 0; col < 8; col++) {
            if (flag[col] == 1 && up[n - col + size - 1] == 1 && down[n + col] == 1) {
                place[n] = col;
                flag[col] = 0;
                up[n - col + size - 1] = 0;
                down[n + col] = 0;
                if (n < (size - 1)) {
                    generate(n + 1);
                } else {
                    print();
                }
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
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }
}
