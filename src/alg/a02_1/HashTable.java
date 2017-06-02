package alg.a02_1;

import java.util.LinkedList;

import alg.a02_1.Pair;

public class HashTable<K, V> implements Map<K, V> {
	public int size;
	public LinkedList<Pair<K, V>>[] array;
	@SuppressWarnings("unchecked")
	public HashTable(int size) {
		this.size = size;
		this.array = new LinkedList[size];
	}

	/**
	 * Methode zur Bestimmung des Indexes innerhalb des Arrays mithilfe einer
	 * hashfunction und abhängig von der größe des Arrays
	 * @param key	der übergebene Key eines key,value pairs
	 * @return int index --> der in dem array vergebene index
	 */
	public int hashfunction(K key) {
		return key.hashCode() % size;
	}
	/**
	 * fuegt ein Schluessel-Wert-Paar in die Map ein
	 * @param key der Schluessel
	 * @param value der Wert
	 * @return falls es schon einen Wert mit Schluessel key in der Map gab,
	 *   wird der alte Wert entfernt und zurueckgegeben; sonst wird null zurueckgegeben
	 */
	@Override
	public V put(K key, V value) {
		//bestimmt den index für den gegebenen key
		int index = hashfunction(key);
		//erstellt ein neues key,value pair aus den übergebenen Werten
		Pair<K, V> pair = new Pair<K, V>(key, value);
		//falls noch kein Key,Value Pair an diesem Index abgespeichert ist wird dieses erstellt
		if (array[index] == null) {
			LinkedList<Pair<K, V>> list = new LinkedList<Pair<K, V>>();
			array[index] = list;
		} else {
			// prüft ob ein Key,Value Pair mit dem selben key bereits vorhanden
			// ist, wenn ja wird ausgetauscht und alter Wert zutückgegeben
			for (int i = 0; i < array[index].size(); i++) {
				if (pair.key.equals(array[index].get(i).key)) {
					Pair<K, V> oldPair = array[index].get(i);
					array[index].set(i, pair);
					return oldPair.getValue();
				}

			}

		}
		array[index].add(pair);
		return null;
	}
	
	
	/**
	 * bestimmt den Wert zu einem Schluessel in der Map
	 * @param key der Schluessel
	 * @return den Wert zum Schluessel key, falls ein entsprechendes Schluessel-Wert-Paar vorhanden ist;
	 *   null sonst
	 */
	@Override
	public V get(K key) {
		int index = hashfunction(key);
		if (array[index] != null) {
			for (int i = 0; i < array[index].size(); i++) {
				// prüft ob der in dem array hinterlegte key dem weitergegebenen
				// key gleicht,wenn ja wird zurückgegeben
				if (array[index].get(i).key.equals(key)) {
					return array[index].get(i).getValue();
				}
			}
		}

		return null;
	}
	
	
	
	/**
	 * entfernt ein Schluessel-Wert-Paar aus der Map
	 * @param key der Schluessel
	 * @return der Wert zu dem Schluessel, falls ein entsprechendes Schluessel-Wert-Paar vorhanden ist;
	 *   null sonst
	 */
	@Override
	public V remove(K key) {
		int index = hashfunction(key);
		if (array[index] != null) {
			for (int i = 0; i < array[index].size(); i++) {
				if (array[index].get(i).key.equals(key)) {
					Pair<K, V> removedPair = array[index].get(i);
					array[index].remove(i);
					return removedPair.getValue();
				}
			}
		}

		return null;
	}

}
