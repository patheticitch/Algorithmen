package alg.a02;

public class Test {

	public static void main(String[] args) {
		HashTable table = new HashTable(7);
		table.put(10, "servus welt");
		System.out.println(table.get(10));
		table.remove(10);
		System.out.println(table.get(10));
		table.put(10, "servus welt");
		System.out.println(table.get(10));
		table.put(10, "jello");
		System.out.println(table.get(10));

	}

	public static void print(HashTable table) {
		for (int i = 0; i < table.size; i++) {
			System.out.println();

		}
	}

}
