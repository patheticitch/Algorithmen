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

	public int getsize() {
		return size;
	}

	public int hashfunction(K key) {
		return key.hashCode() % size;
	}

	@Override
	public V put(K key, V value) {
		int index = hashfunction(key);
		Pair<K, V> pair = new Pair<K, V>(key, value);
		if (array[index] == null) {
			LinkedList<Pair<K, V>> list = new LinkedList<Pair<K, V>>();
			array[index] = list;
		} else {
			// überprüft, ob der gegebene Key bereits an diesem index vorhanen
			// ist
			if (array[index].contains(pair.key) && array[index].contains(pair.hash)) {
				for (int i = 0; i < array[index].size(); i++) {
					if (pair.equals(array[index].get(i))) {
						Pair<K, V> oldPair = array[index].get(i);
						array[index].set(i, pair);
						return oldPair.getValue();
					}
				}
			}

		}
		array[index].add(pair);
		return null;
	}

	@Override
	public V get(K key) {
		int index = hashfunction(key);
		for (int i = 0; i < array[index].size(); i++) {
			if (array[index].get(i).key.equals(key)) {
				return array[index].get(i).getValue();
			}
		}
		return null;
	}

	@Override
	public V remove(K key) {
		int index = hashfunction(key);
		for (int i = 0; i < array[index].size(); i++) {
			if (array[index].get(i).key.equals(key)) {
				Pair<K, V> removedPair = array[index].get(i);
				array[index].remove(i);
				return removedPair.getValue();
			}
		}
		return null;
	}

}
