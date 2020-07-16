package com.gui.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 11, -6, 7, 9, 3, 11, 6, 1};
        //quickSort(arr, 1, arr.length-1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, pivot + 1, high);
            quickSort(arr, low, pivot - 1);
        }

    }

    public static int partition(int[] arr, int low, int high) {

        return 0;
    }
}
