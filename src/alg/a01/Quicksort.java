package alg.a01;

public class Quicksort {
	/********************************************************************************************
	 * Methode zum sortieren eines Arrays (Verfahren Quicksort)
	 * @param array  das zu sortierende Array
	 * Vorbedingung: das Array muss vom Typ int[] sein
	 * @return array  das sortierte array
	 * Effekt -
	 ********************************************************************************************/
	public static int[] sort(int[] array) {
		quicksort(array);
		return array;
	}

	
	/********************************************************************************************
	 * Methode zur initialisierung des Quicksort Verfahrens im Bereich array[0]...array[length-1]
	 * @param array  das zu sortierende Array
	 * @return -
	 * Effekt: Erstaufruf der rekursive Methode quicksort(array,left,right).
	 ********************************************************************************************/
	private static void quicksort(int[] array) {
		quicksort(array, 0, array.length - 1);
	}
	
	
	/********************************************************************************************
	 * Methode quickSort sortiert das Array in den Grenzen von left bis right(inklusive)
	 * (Verfahren rekursiv)
	 * @param array das zu sortierende Array
	 * @param left	linke Indexgrenze des zu sortierenden Arrays
	 * @param right rechte Indexgrenze des zu sortierenden Arrays
	 * @return - 
	 * Effekt: ruft quicksort rekursiv auf bis die terminierungsbedingung erfüllt ist (Länge des Teilarrays beträgt 1) 
	 ********************************************************************************************/
	private static void quicksort(int[] array, int left, int right) {
		if (right - left <= 0)
			return;
		else {
			int pivot = devide(array, left, right);
			quicksort(array, left, pivot -1);
			quicksort(array, pivot + 1, right);
		}
	}

	
	/********************************************************************************************
	 * Methode devide wählt pivot point zum Vergleich an position array[right]
	 * aus und durchsucht das Array von links nach Werten größer als
	 * array[pivot] und von rechts kleiner als array[pivot]. Falls Werte
	 * gefunden werden, und sich die Marker von links und rechts noch nicht
	 * gekreuzt haben, werden die jeweiligen Werte an den Markern ausgewechselt.
	 * Bei einer Überschneidung der Marker terminiert die vorliegende Schleife
	 * und der Wert an array[left] wird mit array[pivot] ausgetauscht. Es wird
	 * der Punkt, an dem sich der Wert von left zurückgegeben, an dem sich nun
	 * der pivot befindet. Alle Werte links von dem pivot sind kleiner und
	 * rechts davon sind größer als er selber.
	 * 
	 * @param array das zu sortierende array
	 * @param left  linker Marker des Teilarrays
	 * @param right  rechter marker des Teilarrays
	 * @return left die endgültige Position des einsortierten Pivot Elements
	 *         Effekt: Vergleicht Werte des Arrays mit einem Pivot Element und
	 *         sortiert dieses an die korrekte Stelle ein
	 ********************************************************************************************/
	
	private static int devide(int[] array, int left, int right) {
		int pivot = right;

		while (true) {
			// sucht ein Element, das größer ist als das Pivot Element.
			while (left < pivot && array[left] <= array[pivot]) {
				left++;
			}
			// sucht ein Element, das kleiner ist als das Pivot Element
			while (right >= left && array[right] > array[pivot]) {
				right--;
			}
			//tauscht das linke Element und das Pivot Element aus, sobald sich die Marker überschneiden und beendet die Methode
			if (right <= left) {
				swap(array, left, pivot);
				break;
			}
			// tauscht Elemente am linken und rechten Marker aus und führt die Methode weiter aus.
			else {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	
	/************************************************************************
	 * Methode swap tauscht die Werte von array[left] und array[right] aus
	 * @param array das gegebene Array
	 * @param left	Index von einem der beiden zu tauschenden Elemente
	 * @param right	Index von einem der beiden zu tauschenden Elemente
	 * Vorbedingung -
	 * @return -
	 * Effekt Werte werden getauscht
	 * 
	*************************************************************************/	
	private static void swap(int[] array, int left, int right) {
		int tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
	}
	
}
