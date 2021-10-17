import java.util.Arrays;

public class Assignment3 {

	public static void main(String[] args) {
		
		int[] arr = {1,5,7,14,6,9,8,13,10,2,15,12,3,11,4};
		
//		printing the indices
		System.out.println("------------ Printing the heaped array with 0th index as # of elements in heap ----------------");
		System.out.println("Printing the array indices:");
		
//		Converting the array to a heapedArray by adding arr.length at 0th index 
		int[] heapedArray = new int[arr.length + 1];
		heapedArray[0] = arr.length;
		for (int i = 1 ; i < heapedArray.length ; i++ ) {
			heapedArray[i] = arr[i-1];
		}
		
		printArray(heapedArray);
		
		System.out.println("##############Converting the array into a minHeap################");

//		minHeapify the array
		heapedArray = minHeapify(heapedArray);
		
		System.out.println("##############Converted the array into a minHeap################");
		
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		
//		perform heapSort on the heapedArray now
		heapedArray = heapSort(heapedArray);
		
//		heapedArray = Arrays.copyOf(heapedArray, 15);
		System.out.println("*********************The sorted array is *****************");
		printArray(heapedArray);

		
	}
	
//	expects a minheap as input. Returns a new sorted array as output
	public static int[] heapSort(int[] heapedArray) {
		int lastIndex = heapedArray[0];
		int[] sortedArray = new int[heapedArray.length-1];
		int i = 0;
		while (lastIndex > 0) {
			int max = heapedArray[lastIndex];
			heapedArray[lastIndex] = heapedArray[1];
			heapedArray[1] = max;
			sortedArray[i] = heapedArray[lastIndex];
			heapedArray[0] = heapedArray[0] - 1;
			lastIndex = heapedArray[0];
			heapedArray = Arrays.copyOf(heapedArray, lastIndex+1); 
			if (heapedArray[0] > 1) {
				percolateDown(heapedArray, 1,lastIndex, true);
				System.out.println("Sorted Array");
				printArray(sortedArray);
				i += 1;
			}
			else if (heapedArray[0] == 1) {
				int temp = sortedArray[i];
				sortedArray[i] = heapedArray[1];
				sortedArray[i+1] = temp;
				break;
			}
		}	
		return sortedArray;
	}

//	prints the indices of the array
	public static void printArrayIndices(int[] arr) {
		for (int i = 0 ; i < arr.length ; i++ ) {
			System.out.printf("%d\t",i);
		}
		System.out.println();
	}
	
//	prints out the array
	public static void printArray(int[] arr) {
		printArrayIndices(arr);
		for (int i = 0 ; i < arr.length ; i++ ) {
			System.out.printf("%d\t",arr[i]);
		}
		System.out.println();
	}

	public static int[] minHeapify(int[] arr) {
		int size = arr.length - 1;
		System.out.println("Starting from the last parent. i.e. ix = " + size + "/2 = " + size/2);
		for ( int i = size/2 ; i > 0 ; i-- ) {
			percolateDown(arr,i,arr.length,false);
		}
		return arr;
	}
	
//	percolate down a value to satisfy the minheap property
	public static void percolateDown(int[] arr, int index, int sizeVal , boolean isPartOfHeapSort) {
		int x = arr[index];
		int leftIndex = getLeftIndex(arr, index);
		int rightIndex = getRightIndex(arr, index);
//		System.out.printf("ix=%d il=%d ir=%d\n",index,leftIndex,rightIndex);
		int leftChild;
		int rightChild;
		if (leftIndex < arr.length && rightIndex < arr.length) {
			leftChild = arr[leftIndex];
			rightChild = arr[rightIndex];
		}
		else {
			leftChild = Integer.MAX_VALUE - 2;
			rightChild = Integer.MAX_VALUE - 1;
		}
		
//		System.out.printf(" x=%d lc=%d rc=%d\n",x,leftChild,rightChild);
		int min = getMinimum(leftChild, rightChild);
		int minIndex = getIndexByValue(arr,min);
		
//		make a recursive call to this below func until the child index is < arr.length
//		if current val > its child, percolate down

		compareAndSwap(arr, index, minIndex, isPartOfHeapSort);
		System.out.println("Heaped Array");
		printArray(arr);
		
	}
	
//	compare and swap the current-index value with the min-index value
	public static void compareAndSwap(int[] arr, int index, int minIndex, boolean isPartOfHeapSort/*, int sizeVal, boolean isVariableArrayLength*/) {
		if (minIndex > arr.length) {
			return;
		}
		else {			
			if (arr[index] > arr[minIndex]) {
				System.out.println("swapping " + arr[index] + " and " + arr[minIndex]);
				int temp = arr[index];
				arr[index] = arr[minIndex];
				arr[minIndex] = temp;
//				swap done
//				now check if further swaps are needed with children
//				now index becomes minIndex and minIndex becomes index
//				now we need to compare the newer minIndex i.e. index with its children

				System.out.println("after swapping " + arr[index] + " and " + arr[minIndex]);
//				
				if(isPartOfHeapSort) {
					index = minIndex;
				}
				
				try {
					int leftIndex = getLeftIndex(arr, index);
					int rightIndex = getRightIndex(arr, index);
					int min = getMinimum(arr[leftIndex], arr[rightIndex]);
					minIndex = getIndexByValue(arr, min);
				} catch (IndexOutOfBoundsException e) {
					return;
				}
				
				if(isPartOfHeapSort) {
					compareAndSwap(arr, index, minIndex, true/*, sizeVal, isVariableArrayLength*/);
				}
				else {
					compareAndSwap(arr, index, minIndex, false/*, sizeVal, isVariableArrayLength*/);
				}
				
			}
			else {
//				no Further Swap Needed
//				System.out.println("no swapping needed. already satisfying the minheap property");
				return;
			}
		}	
	}

	public static int getMinimum(int a, int b) {
		Integer ai = (Integer) a;
		Integer bi = (Integer) b;
		Integer min = ai;
		try {
			min = ai < bi ? ai : bi;
		} catch (Exception e) {
			min = ai;
		}
		return min;
	}
	
	public static int getParent(int[] arr, int i ) {
		return arr[i/2];
	}
	
	public static int getLeft(int[] arr, int i ) {
		return arr[2*i];
	}
	
	public static int getRight(int[] arr, int i ) {
		return arr[2*i + 1];
	}
	
	public static int getIndexByValue(int[] arr, int val) {
		int minIndex = 0;
		for (int i = 1 ; i < arr.length ; i++) {
			if(arr[i] == val) {
				minIndex = i;
				break;
			}
		}
		return minIndex;
	}
	
	public static int getParentIndex(int[] arr, int i ) {
		return i/2;
	}
	
	public static int getLeftIndex(int[] arr, int i ) {
		return 2*i;
	}
	
	public static int getRightIndex(int[] arr, int i ) {
		return 2*i + 1;
	}
	

}
