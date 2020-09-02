package com.gui.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {
		//int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 , 11, 12, 13,14,15,16,17,18,19,20 };
		

		//
//		int resIndex = binarySearch(arr, 0, arr.length - 1, 1000);
//		System.out.println("resIndex=" + resIndex);
		
		List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 1);
		System.out.println("resIndexList=" + resIndexList);
	}

	public static int binarySearch(int[] arr, int left, int right, int findVal) {

		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		int midVal = arr[mid];

		if (findVal > midVal) { // ?? ????
			return binarySearch(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) { // ??????
			return binarySearch(arr, left, mid - 1, findVal);
		} else {
			
			return mid;
		}

	}

	public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

		if (left > right) {
			return new ArrayList<Integer>();
		}
		int mid = (left + right) / 2;
		int midVal = arr[mid];

		if (findVal > midVal) { // ?? ????
			return binarySearch2(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) { // ??????
			return binarySearch2(arr, left, mid - 1, findVal);
		} else {

			
			List<Integer> resIndexlist = new ArrayList<Integer>();
			int temp = mid - 1;
			while(true) {
				if (temp < 0 || arr[temp] != findVal) {//???
					break;
				}
				resIndexlist.add(temp);
				temp -= 1; //temp????
			}
			resIndexlist.add(mid);
			temp = mid + 1;
			while(true) {
				if (temp > arr.length - 1 || arr[temp] != findVal) {//???
					break;
				}
				resIndexlist.add(temp);
				temp += 1;
			}
			
			return resIndexlist;
		}

	}
}
