package alg.a01;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Test {
	
	
	public static void main(String[] args) {
		int[] array=createTestList(10);
		print(array);
		test(array);
	}
	
	public static void print(int[] array) {
		PrintWriter out = new PrintWriter(System.out, true);
		for (int i : array) {
			out.print(i + " ");
		}
		out.println();

	}
	
	

	
	public static int[] createTestList(int size) {
		ArrayList <Integer> list = new ArrayList <Integer>();
		int count=0;
		for(int i=0;i<size;i++) {
			list.add((int) (Math.random()*100));
			count++;
		}
		int[] array = new int[count];
		for(int j=0;j<list.size();j++) {
			array[j]=list.get(j);
		}
		return array;
	}
	
	public static void test (int[] array) {
		Quicksort.sort(array);
		print(array);
		for(int i=0; i<array.length-1;i++) {
			if(array[i]>array[i+1]) {
				System.out.println("error at "+i);
			}
		}
	}

	
	
}
