package alg.a03;

import java.io.PrintWriter;

public class Test {
	
	public static void main(String[] args) {
		Graph<Vertex, Edge<Vertex>> graph = GraphLesen.FileToGraph("./lib/graph20.txt", true);
		PrintWriter out = new PrintWriter(System.out,true);
//		out.println(graph.toString());
		BFS search = new BFS(graph);
		search.BreadthSearch(0,2);
		search.printSearch(out);
		
		//System.out.println(graph.getNeighbours(0));
	}
 
	

}
