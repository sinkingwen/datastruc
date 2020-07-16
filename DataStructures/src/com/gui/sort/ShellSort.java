package com.gui.sort;

import java.util.Arrays;

public class ShellSort {
    public static final int size = 1000000;

    public static void main(String[] args) {
        //int[] arr = {20, 11, -6, 7, 9, 3, 11, 6, 1};
        //测试大数据量情况下的Shell排序
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100000);//产生[0,50000)范围内的随机数
        }
        long s = System.currentTimeMillis();
        shellSortMove(arr);
        long e = System.currentTimeMillis();
        System.out.println("Time(ms):" + (e - s));


    }

    /**
     * 交换法Shell排序
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int len = arr.length;
        int temp = 0;
        int count = 0;
        for (int gap = len / 2; gap >= 1; gap /= 2) {
            count++;
            for (int i = gap; i < len; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j + gap];
                        arr[j + gap] = arr[j];
                        arr[j] = temp;
                    }
                }

            }
            System.out.println("第"+count+"轮：" + Arrays.toString(arr));
        }
    }

    /**
     * 移位法Shell排序
     *
     * @param arr
     */
    public static void shellSortMove(int[] arr) {
        int len = arr.length;
        int insertVal = 0;
        int count = 0;
        for (int gap = len / 2; gap >= 1; gap /= 2) {
            count++;
            //int j = 0;
            for (int i = gap; i < len; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]){
                    while (j - gap >= 0 && temp < arr[j-gap]){
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while后,就给temp找到插入的位置
                    arr[j] = temp;
                }
            }
            //System.out.println("第" + count + "轮：" + Arrays.toString(arr));
        }

    }
}
