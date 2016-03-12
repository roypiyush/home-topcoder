/**
 * 
 */
package com.personal.array;

/**
 * @author piyush
 *
 */
public class MaxSumNonContiguous {

	int FindMaxSum(int arr[], int n) {

		int incl = arr[0];
		int excl = 0;
		int excl_new;
		int i;

		for (i = 1; i < n; i++) {
			/* current max excluding i */
			excl_new = (incl > excl) ? incl : excl;

			/* current max including i */
			incl = excl + arr[i];
			excl = excl_new;
		}

		/* return max of incl and excl */
		return ((incl > excl) ? incl : excl);
	}
	
	void kadaneAlgorithm(int[] arr) {
		
		int maxEnding = arr[0], maxSofar = arr[0];
		int curStart = 0, curEnd = 0, maxStart = 0, maxEnd = 0;
		for (int i = 1; i < arr.length; i++) {
			
			if(arr[i] > maxEnding + arr[i]) {
				curStart = i;
				curEnd = i;
				maxEnding = arr[i];
			}
			else {
				curEnd = i;
				maxEnding = maxEnding + arr[i];
			}
			
			if(maxSofar < maxEnding) {
				maxSofar = maxEnding;
				maxStart = curStart;
				maxEnd = curEnd;
			}
		}
		
		System.out.println(String.format("Max sum = %d From index: %d to index: %d", maxSofar, maxStart, maxEnd));
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 5, 5, 10, 40, 50, 35 };
		MaxSumNonContiguous main = new MaxSumNonContiguous();
		System.out.println(main.FindMaxSum(arr, arr.length));
		
		int arr1[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		main.kadaneAlgorithm(arr1);
	}

}
