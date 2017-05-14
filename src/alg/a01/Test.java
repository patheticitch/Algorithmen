package alg.a01;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Test {
	
	
	public static void main(String[] args) {
		int[] array=createTestList(100000);
		testTime(array);
		//print(array);
		//long start = System.currentTimeMillis();
		//test(array);
		//long elapsedTimeMillis = System.currentTimeMillis()-start;
		//System.out.println(elapsedTimeMillis);
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
			list.add((int) (Math.random()*1000+i));
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
		for(int i=0; i<array.length-1;i++) {
			if(array[i]>array[i+1]) {
				System.out.println("error at "+i);
			}
		}
		print(array);
	}
	
	public static void testTime(int[] array) {
		long start = System.currentTimeMillis();
		Quicksort.sort(array);
		long elapsedTime = System.currentTimeMillis()-start;
		System.out.println(elapsedTime+" ms");
		
	}

	
	
}
