package com.gui.search;

import java.util.Arrays;

public class InsertValSearch {
    public static void main(String[] args) {
        int arr[] = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        //System.out.println(Arrays.toString(arr));
        int findVal = 100;
        int index = insertValSearch(arr, 0, arr.length - 1, findVal);
        System.out.println("index = " + index);
    }

    /**
     *
     * @param arr 数组
     * @param low   左边索引
     * @param high  右边索引
     * @param findVal 查找的值
     * @return 如果找到就返回索引，找不到就返回-1
     */
    private static int insertValSearch(int[] arr, int low, int high, int findVal) {
        System.out.println("插值查找次数打印~");
        if (low > high || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        int mid = low + (findVal - arr[low]) / (arr[high] - arr[low]) * (high - low);
        int midVal = arr[mid];
        if (findVal < midVal) {
            return insertValSearch(arr, low, mid - 1, findVal);
        } else if (findVal > midVal) {
            return insertValSearch(arr, mid + 1, high, findVal);
        } else {
            return mid;
        }

    }

}
