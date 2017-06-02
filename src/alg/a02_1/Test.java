package alg.a02_1;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Test {
	

	public static void main(String[] args) {
		HashTable<String,String> table = new HashTable<String,String>(7);
		table.put("hallo", "servus welt");
		System.out.println(table.get("hallo"));
		table.remove("hello");
		System.out.println(table.get("hello"));

	}

	public static void print(HashTable<Integer,String> table) {
		
	}
	
	public static void printList(LinkedList<Pair<Integer,String>> list,PrintWriter out) {
		ListIterator <Pair<Integer,String>> iterate = list.listIterator();
		while(iterate.hasNext()) {
			Pair<Integer,String> nextPair = iterate.next();
			out.println(nextPair.getKey()+" "+nextPair.getValue());
		}
		out.close();
	}

}
