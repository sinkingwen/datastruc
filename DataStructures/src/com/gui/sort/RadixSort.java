package com.gui.sort;

import java.util.Arrays;

public class RadixSort {
    public static final int size = 100000;
    public static void main(String[] args) {
        //int arr[] = {53, 3, 542, 748, 14, 214};

        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random()*500000);//产生[0,50000)范围内的随机数
        }
        long s = System.currentTimeMillis();
        radixSort(arr);
        long e = System.currentTimeMillis();
        System.out.println("Time(ms):"+(e-s));
    }

    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int[][] bucket = new int[10][arr.length];
        int[] countArrEle = new int[10];


        int round = (max + "").length();

        for (int i = 0, n = 1; i < round; i++, n *= 10) {
            int index = 0;
            for (int j = 0; j < arr.length; j++) {
                int number = arr[j] / n % 10;
                bucket[number][countArrEle[number]++] = arr[j];
            }
            for (int j = 0; j < bucket.length; j++) {
                if (countArrEle[j] != 0) {
                    for (int k = 0; k < countArrEle[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                }
            }
            for (int l = 0; l < countArrEle.length; l++) {
                countArrEle[l] = 0;
            }
            //System.out.println("第" + (i + 1) + "轮" + Arrays.toString(arr));
        }
    }
}