
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Assignment1Q2 {
	
	public static int recursiveTertiarySearch(int[] li, int val, int low, int high) {

//		base-case-1
		if (low >= high) {
			System.out.printf("\nNot found: -1");
			return -1;
		}
//		base-case-2
		if (val == li[low]) {
			System.out.printf("\nFound at low: " + low);
			return low;
		}
//		base-case-3
		if (val == li[high]) {
			System.out.printf("\nFound at high: " + high);
			return high;
		} else {
//			location of first one-third index
			int mid1 = low + (high - low)/3;
//			location of last one-third index
			int mid2 = high - (high - low)/3;
			System.out.printf("\nFinding in middle. mid1 = %d, mid2 = %d ", mid1, mid2);

			if (val <= li[mid1]) {
				System.out.printf("\nCalling recursiveTertiarySearch(li,%d,%d,%d) in 1st part", val, low, mid1);
				return recursiveTertiarySearch(li, val, low, mid1);	
			} else if (val > li[mid1] && val <= li[mid2]) {
				System.out.printf("\nCalling recursiveTertiarySearch(li,%d,%d,%d) in 2nd part", val, mid1+1, mid2);
				return recursiveTertiarySearch(li, val, mid1+1, mid2);
			}
			System.out.printf("\nCalling recursiveTertiarySearch(li,%d,%d,%d) in 3rd part", val, mid2+1, high);
			return recursiveTertiarySearch(li, val, mid2+1, high);
		}
	}
	
	public static int recursiveBinarySearch(int[] a, int v, int l, int h) {
		if (l > h) {
			System.out.printf("\nNot Found: %d", -1 );
			return -1;
		}
		int m = (l+h)/2;
		if (v == a[m]) {
			System.out.printf("\nFound at " + m);
			return m;
		} else if (v < a[m]) {
			System.out.printf("\nCalling recursiveBinarySearch(li,%d,%d,%d)", v, l, m - 1);
			return recursiveBinarySearch(a, v, l, m - 1);
		}
		System.out.printf("\nCalling recursiveBinarySearch(li,%d,%d,%d)", v, m+1, h);
		return recursiveBinarySearch(a, v, m+1, h); 
	}

	public static void main(String[] args) {
		
//		initialising the array
		Integer[] arr = {2,3,54,6,8,345,25,235,623,9,62};
		
//		printing the array
		for (int i : arr) {
			System.out.print(i + "\t ");
		}
		
//		converting the array to list for sorting it
		List<Integer> li = new ArrayList<Integer>(arr.length);
		for(int i = 0; i < arr.length; i++) {
			li.add(arr[i]);
		}
		
//		sorting the list
		System.out.println("\nSorting the list");
		Collections.sort(li);
		
//		printing the sorted list
		li.forEach(i -> System.out.print(i + "\t"));
		
		System.out.println();
		
//		printing the indices
		for(int i = 0; i < arr.length; i++) {
			System.out.print(i + "\t");
		}
		
		int val = 100;
		int low = 0;
		int high = arr.length - 1;
		System.out.println("\nFinding val: " + val + " in the list\n");
		
//		converting the list back to array
		int[] ar = new int[li.size()];
		for(int i = 0; i < li.size(); i++) {
			ar[i] = li.get(i);
		}
		
		System.out.printf("Calling recursiveTertiarySearch(ar,%d,%d,%d)\n",val, low, high);
		
		int y = recursiveTertiarySearch(ar, val, low, high);
		
		if (y != -1) {
			System.out.printf("\nFound value %d at %d", val, y);
		}
		

//		System.out.printf("recursiveBinarySearch(ar,%d,%d,%d)", val, 0, ar.length - 1);
//		int x = recursiveBinarySearch(ar, val, 0, ar.length - 1);
//		System.out.println("\n" + x);
		

	}

}
