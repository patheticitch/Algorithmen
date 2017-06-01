package alg.a02;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashTable<K, V> implements Map<K, V> {

	protected int size;
	

	public HashTable(int size) {
		this.size = size;
		

	}

	@Override
	public V put(K key, V value) {
		int index= hashfunction(key);
		//look if the value is already inside
		if(array.get(index).equals(Node(key,value)))) {
			
		}
	}

	@Override
	public V get(K key) {
		int index = hashfunction(key);
		for (Node<K, V> node = nodes[index]; node != null; node = node.next) {
			if ((index == node.hash) && (key.equals(node.key))) {
				return node.value;
			}
		}

		return null;
	}

	@Override
	public V remove(K key) {
		//look if key value pair is there
		int index=hashfunction(key);
		for (Node<K, V> node = nodes[index]; node != null; node = node.next) {
			if ((index == node.hash) && (key.equals(node.key))) {
				
			}
		}
		return null;
	}

	public int hashfunction(K key) {
		return key.hashCode() % size;
	}

}
