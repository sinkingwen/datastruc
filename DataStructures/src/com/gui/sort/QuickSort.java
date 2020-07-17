package com.gui.sort;

public class QuickSort {
    public static final int size = 1000000;
    public static void main(String[] args) {
        //int[] arr = {2, 11, -6, 7, 9, 3, 11, 6, 1};
        //测试大数据量情况下的插入排序
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random()*500000);//产生[0,50000)范围内的随机数
        }
        long s = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long e = System.currentTimeMillis();
        System.out.println("Time(ms):"+(e-s));//180ms
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int base = arr[low];
        int i = low;
        int j = high;
        while (i != j) {
            while (base <= arr[j] && i < j) {
                j--;
            }
            while (base >= arr[i] && i < j) {
                i++;
            }
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[low] = arr[i];
        arr[i] = base;
        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }


}
