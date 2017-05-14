package alg.a01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		testFromFiles("./lib/");

	}
	
	/*****************************************************************************
	 * Die Methode testFromFiles testet die sort Methode aus der Klasse
	 * Quicksort und schreibt für jede Test Datei den File Namen und die
	 * Laufzeit in ms in eine Datei test.txt
	 * 
	 * @param pathname Pfad des Orderns, in dem die Testdateien hinterlegt sind
	 * @return -
	 */

	public static void testFromFiles(String pathname) {
		try {
			File dir = new File(pathname);
			String[] files = dir.list();
			FileWriter fw = new FileWriter("./test/test.txt");
			for (String file : files) {
				fw.write(file + " " + testTimeFromFile("./lib/" + files[0]).toString() + " ms \n");
			}
			fw.close();
		} catch (IOException e) {
			System.err.println("IOException");
		}

	}
	/*****************************************************************************
	 * erstellt ein int array mit der gegebenen testMethode FileIntArray und gibt die Zeit in ms zurück 
	 * @param filename  Pfad der Datei, die getestet werden soll
	 * @return testTime  Laufzeit in ms
	 */

	public static Long testTimeFromFile(String filename) {
		int[] array = FileIntArray.FileToIntArray(filename);
		return testTime(array);

	}
	/*****************************************************************************
	 * Führt die Methode sort aus Quicksort aus und gibt die Laufzeit zurück
	 * @param array das gegebene Array
	 * @return elapsedTime die Laufzeit der Sortierung in ms
	 */
	public static long testTime(int[] array) {
		long start = System.currentTimeMillis();
		Quicksort.sort(array);
		long elapsedTime = System.currentTimeMillis() - start;
		return elapsedTime;

	}

}
