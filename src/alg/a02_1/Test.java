package alg.a02_1;

public class Test {
	

	public static void main(String[] args) {
		HashTable<Integer,String> table = new HashTable<Integer,String>(7);
		table.put(10, "servus welt");
		System.out.println(table.get(10));
		table.remove(10);
		System.out.println(table.get(10));

	}

	public static void print(HashTable<Integer,String> table) {
		for (int i = 0; i < table.size; i++) {
			System.out.println();

		}
	}

}
