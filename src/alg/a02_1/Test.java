package alg.a02_1;

public class Test {
	

	public static void main(String[] args) {
		HashTable <Integer,String> table = new HashTable <Integer,String>(7);
		testPut(table,10,"test");
		testPut(table,10,"hello");
		testPut(table,30,"something something to test");
		testPut(table,30,"something something to test");

	}

	
	/**
	 * testet die put Methode der HashTable Klasse mit Integer als Key und String als Value
	 * @param table	
	 */
	public static void testPut(HashTable<Integer,String> table,Integer Key,String Value) {
		table.put(Key, Value);
		if(isEqual(table,Key,Value)){
			System.out.println("success");
		}
		else {
			System.out.println("failed");
		}
		
	}
	
	/**
	 * testet für gegebene key und value pairs,ob der key innerhalb einer
	 * HashTable denselben Wert hat wie der durchgegebene Value
	 * 
	 * @param table	gegebene HashTable
	 * @param Key	der Schlüssel nach dem der Wert abgefragt wird
	 * @param Value	Der zu erwartende Wert
	 * @return	boolean
	 */
	public static boolean isEqual(HashTable<Integer,String> table,Integer Key,String Value) {
		if(table.get(Key).equals(Value)) {
			return true;
		}
		return false;
	}
	
	

}
