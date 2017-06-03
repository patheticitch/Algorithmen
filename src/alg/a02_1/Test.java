package alg.a02_1;

public class Test {
	

	public static void main(String[] args) {
		HashTable <Integer,String> table = new HashTable <Integer,String>(7);
		testPut(table,10,"test");
		testPut(table,10,"hello");
		testPut(table,30,"something something to test");
		testPut(table,30,"something something to test");
		testRemove(table,40,"test1");
		testRemove(table,30,"test2");
		testGet(table,50,"test3");
		testGet(table,40, "test4");

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
	 * testet ob ein zuvor hinzugefügtes Key-Value-Pair entfernt wurde und der Wert zurückgegeben wurde
	 * 
	 * @param table gegebene HashTable
	 * @param key	der gegebene Schlüssel
	 * @param value der zugehörige Wert
	 */
	public static void testRemove(HashTable<Integer, String> table, Integer key, String value){
		table.put(key, value);
		if(isEqual(table, key, value)){
			String v = table.remove(key);
			table.remove(key);
			if(table.get(key) == null && v == value){
				System.out.println("Succes");
			}else{
				System.out.println("failed");
			}
		}
	}
	
	
	/** 
	 * testet ob zu einem zuvor hinzugefügten Key-Value-Pair,
	 *  mit der Methode get(key) der entsprechende Wert zurückgegeben wird
	 * @param table gegebene HashTable
	 * @param key der gegebene Schlüssel
	 * @param value der zugehörige Wert
	 */
	public static void testGet(HashTable<Integer, String> table, Integer key, String value){
		table.put(key, value);
		if(isEqual(table, key, value)){
			if(table.get(key) == value){
				System.out.println("Succes");
			}else{
				System.out.println("failed");
			}
		}
	}
	
	
	/**
	 * testet für gegebene key-value-pairs, ob der key innerhalb einer
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
