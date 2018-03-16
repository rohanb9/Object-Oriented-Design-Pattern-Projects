package com.animalfarm.strategy;

import java.util.*;

public class Code {
	
	static String calculateWeights(int input) {		
		return Integer.toString(input/5) +" "+ Integer.toString(input%5);
	}
	
	static int positionsRotated(int arr[], int l, int h)
	{

		if (h < l) return 0;
		else if (h == l) return l;
		
		int mid = l + (h - l)/2; 
		
		
		if (mid < h && arr[mid+1] < arr[mid]) return (mid + 1);
		else if (mid > l && arr[mid] < arr[mid - 1]) return mid;
		else if (arr[h] > arr[mid]) return positionsRotated(arr, l, mid - 1);
		else return positionsRotated(arr, mid + 1, h);
	}

	public static void main(String a[]) {
		/*Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		Integer i = Integer.parseInt(s);
		System.out.println(s);
		System.out.println(i);
		
		int n = 100;
		String val = "";
		for(int i = 1; i <= n; i++) {
			if(i % 5 == 0) {
				val = "Bing";
			} else if(i %7 == 0) {
				val = "Bong";
			} else {
				val = Integer.toString(i);
			}
			System.out.println(val);
		}
		*/
		
		int arr[] = {15, 18, 2, 3, 6, 12};
        int n = arr.length;
         
        System.out.println(calculateWeights(27));
        
		
		
		//sc.close();
		
	}
}
