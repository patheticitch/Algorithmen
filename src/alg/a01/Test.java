package alg.a01;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Test {
	
	
	public static void main(String[] args) {
		test(10);
		test(20);
	}
	
	public static void print(int[] array) {
		PrintWriter out = new PrintWriter(System.out, true);
		for (int i : array) {
			out.print(i + " ");
		}
		out.println();

	}
	
	private static int[] sorted(int[] array) {
		Quicksort.quicksort(array);
		return array;
	}

	
	public static void test(int size) {
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
		print(array);
		print(sorted(array));
		
	}

	
	
}
