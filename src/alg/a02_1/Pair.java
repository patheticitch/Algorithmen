package alg.a02_1;

public class Pair <K,V> {
	protected int hash;
	protected K key;
	protected V value;
	
	public Pair (K key, V value){
		this.key = key;
		this.value = value;
		this.hash = key.hashCode();
	}
	
	public Pair(K key, V value, int hash){
		this.key = key;
		this.value = value;
		this.hash = hash;
	}
	
	public K getKey(){
		return this.key;
	}
	
	public V getValue(){
		return this.value;
	}
	
	public int getHash(){
		return this.hash;
	}

}
