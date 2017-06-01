package alg.a02_1;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Test {
	

	public static void main(String[] args) {
		HashTable<Integer,String> table = new HashTable<Integer,String>(7);
		table.put(10, "servus welt");
		System.out.println(table.get(10));
		table.remove(10);
		System.out.println(table.get(10));

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
