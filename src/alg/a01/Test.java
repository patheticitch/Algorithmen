package alg.a01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		testFromFiles("./lib/");
		
	}
	
	public static void testFromFiles(String pathname)  {
		try {
			File dir = new File(pathname);
			String [] files = dir.list();
			FileWriter fw = new FileWriter("./test/test.txt");
			for(String file: files) {
				fw.write(file+" "+testTimeFromFile("./lib/"+files[0]).toString()+" ms \n");
			}
			fw.close();
		}
		catch(IOException  e) {
			System.err.println("IOException");
		}
		
		
		
	}

	public static Long testTimeFromFile (String filename) {
		int [] array= FileIntArray.FileToIntArray(filename);
		return testTime(array);
		
	}
	
	public static void print(int[] array) {
		PrintWriter out = new PrintWriter(System.out, true);
		for (int i : array) {
			out.print(i + " ");
		}
		out.println();

	}

	public static int[] createTestList(int size) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			list.add((int) (Math.random() * 1000 + i));

		}
		int[] array = new int[list.size() - 1];
		for (int j = 0; j < list.size(); j++) {
			array[j] = list.get(j);
		}
		return array;
	}

	public static void test(int[] array) {
		Quicksort.sort(array);
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				System.out.println("error at " + i);
			}
		}
		print(array);
	}

	public static long testTime(int[] array) {
		long start = System.currentTimeMillis();
		Quicksort.sort(array);
		long elapsedTime = System.currentTimeMillis() - start;
		return elapsedTime;

	}

}
