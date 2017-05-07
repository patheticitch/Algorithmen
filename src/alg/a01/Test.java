package alg.a01;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Test {
	
	
	public static void main(String[] args) {
		int i = 2;
		int pivot = i;
		i++;
		
		
		
	}
	
	public static int[] createTestArray(int size) {
		ArrayList <Integer> list = new ArrayList <Integer>();
		for(int i=0;i<size;i++) {
			list.add((int) (Math.random()*100));
			
		}
		int[] array = new int[list.size()];
		for(int j=0;j<list.size();j++) {
			array[j]=list.get(j);
		}
		return array;
	}
	
	public static void print(int[] array) {
		PrintWriter out = new PrintWriter(System.out,true);
		for(int i: array) {
			out.printf("%d ", i);
		}
		out.println();
	}
}
