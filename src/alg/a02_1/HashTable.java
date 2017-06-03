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
	 * hashfunction und der Modulo-Operation, abhängig von der größe des Arrays
	 * @param key	der übergebene Key eines key,value pairs
	 * @return int index --> der in dem array vergebene index
	 * Effekt: Index für den übergebenden Key wird bestimmt
	 */
	public int hashfunction(K key) {
		return key.hashCode() % size;
	}
	
	/**
	 * Methode erstellt ein neues Schlüssel-Wert-Paar und fügt dieses in die LinkedList (im Array an der Stelle des Indexes von key) ein
	 * wenn noch kein Paar an diesem Index gespeichert wurde, wird zuerst eine neue Liste erstellt
	 * @param key der Schluessel
	 * @param value der Wert
	 * @return falls es schon einen Wert mit Schluessel key in der Map gibt,
	 *   wird der alte Wert entfernt und zurueckgegeben; sonst wird null zurueckgegeben
	 * Effekt: fügt ein Schlüssel-Wert-Paar in die Map ein und ersetzt ggf. den alten Wert
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
	 * prüft, ob der übergebende Schlüssel in der Liste(am Index von key) vorhanden ist und gibt den zugehörigen Wert zurück
	 * @param key der Schluessel
	 * @return den Wert zum Schluessel key, falls ein entsprechendes Schluessel-Wert-Paar vorhanden ist;
	 *   null sonst
	 * Effekt: bestimmt den Wert zum übergebenden Schlüssel in der Map
	 */
	@Override
	public V get(K key) {
		int index = hashfunction(key);
		if (array[index] != null) {
			for (int i = 0; i < array[index].size(); i++) {
				if (array[index].get(i).key.equals(key)) {
					return array[index].get(i).getValue();
				}
			}
		}
		return null;
	}
	
	
	
	/**
	 * prüft, ob zu dem übergebenen Schlüssel in der Liste(am Index von key) ein Schlüssel-Wert-Paar vorhanden ist, 
	 * löscht dieses und gibt den zugehörigen Wert zurück
	 * @param key der Schluessel
	 * @return der Wert zu dem Schluessel, falls ein entsprechendes Schluessel-Wert-Paar vorhanden ist;
	 *   null sonst
	 * Effekt: entfernt ein Schlüssel-Wert-Paar aus der Map
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
