package com.personal.array;

import java.util.Arrays;

public class BinarySearchMain {

	/**
	 * 
	 * Basic algorithm for binary search
	 * 
	 * @param arr
	 * @param min
	 * @param max
	 * @param key
	 * @return index if element exists otherwise -1
	 */
	int binarySearch(int arr[], int min, int max, int key) {

		if (max < min)
			return -1;

		int mid = (min + max) >> 1;

		if (key < arr[mid])
			return binarySearch(arr, min, mid - 1, key);
		else if (key > arr[mid])
			return binarySearch(arr, mid + 1, max, key);
		else
			return mid;

	}
	
	int upperBound(int arr[], int key) {
		
		int low = 0; int high = arr.length - 1; int mid = 0;
		
		while(low <= high) {
			mid = (low + high) >> 1;
			
			if(arr[mid] > key && (mid == 1 || arr[mid - 1] <= key)) {
				return mid;
			}
			else if(arr[mid] > key) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		
		return mid;
	}
	
	int lowerBound(int arr[], int key) {
		
		int low = 0; int high = arr.length - 1; int mid = 0;
		
		while(low <= high) {
			mid = (low + high) >> 1;
			
			if(arr[mid] >= key && (mid == 1 || arr[mid - 1] < key)) {
				return mid;
			}
			else if(arr[mid] >= key) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		
		return mid;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16,
				17, 18, 19, 20 };

		BinarySearchMain main = new BinarySearchMain();
		System.out.println(Arrays.toString(arr));
		int index = 0;
		System.out.println((index = main.binarySearch(arr, 0, arr.length - 1, 10)) != -1 ? "Element found at " + index : "Element not Found!");
		System.out.println((index = main.binarySearch(arr, 0, arr.length - 1, 100)) != -1 ? "Element found at " + index : "Element not Found!");
		System.out.println((index = main.binarySearch(arr, 0, arr.length - 1, 0)) != -1 ? "Element found at " + index : "Element not Found!");
		System.out.println((index = main.binarySearch(arr, 0, arr.length - 1, 1)) != -1 ? "Element found at " + index : "Element not Found!");
		System.out.println((index = main.binarySearch(arr, 0, arr.length - 1, 20)) != -1 ? "Element found at " + index : "Element not Found!");
		
		int upperBound = 1;
		index = main.upperBound(arr, upperBound);
		System.out.println(String.format("Upper bound found for key:%d at index:%d element:%d", upperBound, index, arr[index]));
		
		int lowerBound = 13;
		index = main.lowerBound(arr, lowerBound);
		System.out.println(String.format("Lower bound found for key:%d at index:%d element:%d", lowerBound, index, arr[index]));
		
		
		lowerBound = -1;
		index = main.lowerBound(arr, lowerBound);
		System.out.println(String.format("Lower bound found for key [which does not exist]:%d at index:%d element:%d", lowerBound, index, arr[index]));
		
		lowerBound =  100;
		index = main.lowerBound(arr, lowerBound);
		System.out.println(String.format("Lower bound found for key [which does not exist]:%d at index:%d element:%d", lowerBound, index, arr[index]));
		
	}

}
