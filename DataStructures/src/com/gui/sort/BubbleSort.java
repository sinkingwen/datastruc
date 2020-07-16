package com.gui.sort;

import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static final int size = 100000;
    public static void main(String[] args) {
        //int[] arr = {20, 11, -6, 7, 9, 3, 11};

        //测试大数据量情况下的冒泡排序
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random()*500000);//产生[0,50000)范围内的随机数
        }
        long s = System.currentTimeMillis();
        bubbleSort(arr);
        long e = System.currentTimeMillis();
        System.out.println("Time(s):"+(e-s)/1000);
//        bubbleSort(arr);
//        System.out.println("排序后的结果：");
//        System.out.println(Arrays.toString(arr));

    }

    /**
     * 优化后的冒泡排序
     * @param arr 数组
     */
    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;//重置进行下一趟的排序
            }
        }
    }
}
