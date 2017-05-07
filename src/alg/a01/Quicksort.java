package alg.a01;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Quicksort {

	public static void main(String[] args) {
		test(10);
		test(5);

	}

	
	public static void quicksort(int[] array) {
		//starts the quicksort
		quicksort(array, 0, array.length - 1);
	}

	public static void quicksort(int[] array, int left, int right) {
		//terminates the method if the array behind the pivot is only one element long
		if (right - left <= 0)
			return;
		else {
			int pivot = devide(array, left, right);
			quicksort(array, left, pivot - 1);
			quicksort(array, pivot + 1, right);
		}

	}
	// devide function returns the position of the pivot element. Everything behind the pivot element is smaller and everything after the pivot is larger than itself
	public static int devide(int[] array, int left, int right) {
		// choose pivot for comparison
		int pivot = right;
		int rightmarker = right;

		// outer loop terminates when right <= left means when the markers corss
		while (left <= rightmarker) {

			// looks for an element larger than the pivot
			while (left < pivot && array[left] <= array[pivot]) {
				left++;
			}
			//looks for an element smaller than the pivot
			while (rightmarker >= left && array[rightmarker] > array[pivot]) {
				rightmarker--;
			}
			// if markers cross swap the left element with the pivot
			if (rightmarker <= left) {
				swap(array, left, pivot);
				break;
			}
			// else swap values at left and right marker
			else {
				swap(array, left, rightmarker);
				left++;
				rightmarker--;
			}
		}
		// return the new pivot point 

		return left;

	}

	public static void swap(int[] array, int left, int right) {
		int tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
	}

	public static void print(int[] array) {
		PrintWriter out = new PrintWriter(System.out, true);
		for (int i : array) {
			out.print(i + " ");
		}
		out.println();

	}
	
	public static int[] sorted(int[] array) {
		quicksort(array);
		return array;
	}

	
	public static void test(int size) {
		ArrayList <Integer> list = new ArrayList <Integer>();
		int count=0;
		for(int i=0;i<size;i++) {
			list.add((int) (Math.random()*10));
			count++;
		}
		int[] array = new int[count];
		for(int j=0;j<list.size();j++) {
			array[j]=list.get(j);
		}
		print(array);
		print(sorted(array));
		
	}

}
