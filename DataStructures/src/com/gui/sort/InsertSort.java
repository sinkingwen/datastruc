package com.gui.sort;

import java.util.Arrays;

public class InsertSort {
    public static final int size = 1000000;
    public static void main(String[] args) {
        //int[] arr = {20, 11, -6, 7, 9, 3, 11};

        //测试大数据量情况下的插入排序
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random()*500000);//产生[0,50000)范围内的随机数
        }
        long s = System.currentTimeMillis();
        insertSort(arr);
        long e = System.currentTimeMillis();
        System.out.println("Time(ms):"+(e-s));

    }

    public static void insertSort(int[] arr) {
        int len = arr.length;
        int val = 0;
        int index = 0;
        for (int i = 0; i < len - 1; i++) {
            index = i + 1;
            val = arr[index];

            while (index > 0) {
                if (val < arr[index - 1]) {
                    arr[index] = arr[index - 1];
                    arr[index - 1] = val;
                } else {
                    break;
                }
                index--;
            }
            //System.out.println(Arrays.toString(arr));
        }
    }
}
