package alg.a02;

public class Pair {
	protected int hash;
	protected Integer key;
	protected String value;
	
	public Pair(Integer key, String value){
		this.key = key;
		this.value = value;
		this.hash = key.hashCode();
	}
	
	public Pair(int key, String value, int hash){
		this.key = key;
		this.value = value;
		this.hash = hash;
	}
	
	public Integer getKey(){
		return this.key;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public int getHash(){
		return this.hash;
	}
}
