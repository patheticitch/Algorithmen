package alg.a02;

public class Node<K, V>{
	protected int hash;
	protected K key;
	protected V value;
	protected Node<K, V> next;

	public Node(K key, V value) {
		this.key = key;
		this.value = value;
		this.hash=key.hashCode();
	}
	
	public Node (K key, V value, Node<K,V> next, int hash){
        this.key = key;
        this.value = value;
        this.next = next;
        this.hash = hash;
    }

	public K getKey() {
		return this.key;
	}

	public V getValue() {
		return this.value;
	}

	public Node<K, V> getNext() {
		return this.next;
	}

	public void setNext(Node<K, V> next) {
		this.next = next;
	}
	public boolean hasNext() {
		if(this.next==null){
			return false;
		}
		return true;
	}
	public int getHash() {
		return this.hash;
	}
	
}
