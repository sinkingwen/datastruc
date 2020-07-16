package com.gui.sort;

import java.util.Arrays;

public class SelectSort {
    public static final int size = 100000;
    public static void main(String[] args) {
        //int[] arr = {20, 11, -6, 7, 9, 3, 11};
        //测试大数据量情况下的选择排序
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random()*500000);//产生[0,50000)范围内的随机数
        }
        long s = System.currentTimeMillis();
        selectSort(arr);
        long e = System.currentTimeMillis();
        System.out.println("Time(ms):"+(e-s));
    }

    public static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];//赋值操作
                    minIndex = j;
                }
            }
            if (minIndex != i) {//交换操作
                arr[minIndex] = arr[i];
                arr[i] = min;

            }
        }
    }
}
