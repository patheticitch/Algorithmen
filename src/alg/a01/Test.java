package alg.a01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		testTimeFromFiles("./lib/");
		testIfSorted("./lib/");
		
		
		
		
		
	}
	
	/*****************************************************************************
	 * Die Methode testFromFiles testet die sort Methode aus der Klasse
	 * Quicksort und schreibt für jede Test Datei den File Namen und die
	 * Laufzeit in ns in eine Datei test.txt
	 * 
	 * @param pathname Pfad des Orderns, in dem die Testdateien hinterlegt sind
	 * @return -
	 */
	public static void testTimeFromFiles(String pathname) {
		try {
			File dir = new File(pathname);
			String[] files = dir.list();
			FileWriter fw = new FileWriter("./test/test.txt");
			for (int i=0;i<files.length;i++) {
				String time = testTimeFromFile("./lib/" +files[i]).toString();
				fw.write(files[i] + " " + time + " ns \n");
			}
			fw.close();
		} catch (IOException e) {
			System.err.println("IOException");
		}

	}
	/*****************************************************************************
	 * erstellt ein int array mit der gegebenen testMethode FileIntArray und gibt die Zeit in ns zurück 
	 * @param filename  Pfad der Datei, die getestet werden soll
	 * @return testTime  Laufzeit in ns
	 */

	public static Long testTimeFromFile(String filename) {
		int[] array = FileIntArray.FileToIntArray(filename);
		return testTime(array);

	}
	/*****************************************************************************
	 * Führt die Methode sort aus Quicksort aus und gibt die Laufzeit zurück
	 * @param array das gegebene Array
	 * @return elapsedTime die Laufzeit der Sortierung in ns
	 */
	public static long testTime(int[] array) {
		long start = System.nanoTime();
		Quicksort.sort(array);
		long elapsedTime = System.nanoTime() - start;
		return elapsedTime;

	}
	
	public static boolean isSorted(int[] array) {
		for(int i=0;i<array.length-1;i++) {
			if(array[i]<=array[i+1]) {
				continue;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public static void testIfSorted(String pathname) {
		try {
			File dir = new File(pathname);
			String[] files = dir.list();
			FileWriter fw = new FileWriter("./test/test_2.txt");
			for (int i=0;i<files.length;i++) {
				int[] array = FileIntArray.FileToIntArray("./lib/"+files[i]);
				Quicksort.sort(array);
				if(isSorted(array)==false) {
					fw.write(files[i]+" is not sorted \n");
				}
				
			}
			fw.close();
		} catch (IOException e) {
			System.err.println("IOException");
		}
	}
	
	
	
	 
	
	
	

}
