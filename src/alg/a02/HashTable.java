package alg.a02;

import java.util.LinkedList;
import java.util.ListIterator;

public class HashTable implements Map {

	public int size;
	public LinkedList<Pair>[] array;

	@SuppressWarnings("unchecked")
	public HashTable(int size) {
		this.size = size;
		this.array = new LinkedList[size];
	}

	public int getsize() {
		return size;
	}

	@Override
	public String put(Integer key, String value) {
		// look if there is a key-value pair in the given index
		// if it is -->
		int index = hashfunction(key);
		Pair pair = new Pair(key, value);
		if (array[index] == null) {
			LinkedList<Pair> list = new LinkedList<Pair>();
			array[index] = list;
		} else {
			// überprüft, ob der gegebene Key bereits an diesem index vorhanen
			// ist
			// iterate trough the Linked List at given index
			for (int i = 0; i < array[index].size(); i++) {
				if (pair.key.equals(array[index].get(i).key)) {
					Pair oldPair = array[index].get(i);
					array[index].set(i, pair);
					return oldPair.getValue();
				}
			}

		}
		array[index].add(pair);
		return null;
	}

	@Override
	public String get(Integer key) {
		int index = hashfunction(key);
		for (int i = 0; i < array[index].size(); i++) {
			if (array[index].get(i).key.equals(key)) {
				return array[index].get(i).getValue();
			}
		}
		return null;
	}

	@Override
	public String remove(Integer key) {
		int index = hashfunction(key);
		for (int i = 0; i < array[index].size(); i++) {
			if (array[index].get(i).key.equals(key)) {
				Pair removedPair = array[index].get(i);
				array[index].remove(i);
				return removedPair.getValue();
			}
		}
		return null;
	}

	public int hashfunction(Integer key) {
		return key.hashCode() % size;
	}

}
