package alg.a03;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	private Graph<Vertex, Edge<Vertex>> graph;
	public LinkedList<Node> visitedList;
	public Queue<Node> queue;

	public BFS(Graph<Vertex, Edge<Vertex>> graph) {
		this.graph = graph;
		this.queue = new LinkedList<Node>();
		this.visitedList = new LinkedList<Node>();
	}

	public void BreadthSearch(int start, int end) {
		// initialize first node with pred: null and dist=0
		Node first = new Node(graph.getVertex(start), null, 0);
		// leave the last Vertex as it is for now because i don't know pred and
		// dist so far
		Vertex last = graph.getVertex(end);
		// add first Node to the queues
		queue.add(first);
		while (!queue.isEmpty()) {
			if (first.getVertex().equals(last)) {
				break;
			}
			Node dequeueVertex = queue.poll();
			if (dequeueVertex.getVertex().equals(last)) {
				addToVisited(dequeueVertex);
				break;
			}
			getNeighbors(dequeueVertex);
		}

	}
	
	public Node BreadthSearch(int start) {
		Node first = new Node(graph.getVertex(start), null, 0);
		queue.add(first);
		while(!queue.isEmpty()) {
			Node dequeueVertex = queue.poll();
			getNeighbors(dequeueVertex);
		}
		return visitedList.getLast();
		
	}
	
	private LinkedList<Vertex> getShortestPathBetween(int start, int end) {
		BreadthSearch(start, end);
		LinkedList<Node> completedSearch = new LinkedList<Node>(this.visitedList);
		LinkedList<Vertex> shortest = new LinkedList<Vertex>();
		Node last = completedSearch.getLast();
		shortest.add(last.getVertex());
		while (getPred(completedSearch, last) != null) {
			Node pred = getPred(completedSearch, last);
			shortest.add(pred.getVertex());
			last = pred;
		}
		return shortest;

	}
	
	public void printShortest(int start,int end) {
		LinkedList <Vertex> shortest = getShortestPathBetween(start,end); 
		Iterator <Vertex> iterate = shortest.descendingIterator();
		while(iterate.hasNext()) {
			System.out.print(iterate.next().toString()+" ");
		}
		
		System.out.println();
	}
	
	public Node getPred(LinkedList<Node> list,Node end) {
		//durchlaufe NodeListe auf der Suche nach Pred
		for(Node n: list) {
			if(end.getPred()==null) {
				return null;
			}
			else if(end.getPred().equals(n.getVertex())) {
				return n;
			}
		}
		return null;
	}

	private void addToVisited(Node v) {
		if (!isVisited(v)) {
			visitedList.add(v);
		}
	}

	private void getNeighbors(Node v) {
		addToVisited(v);
		Collection<Vertex> neighbors = graph.getNeighbours(v.getVertex());
		Iterator<Vertex> nIt = neighbors.iterator();
		while (nIt.hasNext()) {
			Node nextVertex = new Node(nIt.next(), v.getVertex(), v.dist + 1);
			if (!isVisited(nextVertex)) {
				queue.add(nextVertex);
			}

		}
	}

	private boolean isVisited(Node v) {
		if (visitedList.contains(v)) {
			// System.out.println("contains "+v);
			return true;
		}
		return false;
	}
	
	 

	public void printSearch(PrintWriter out) {
		for (Node i : visitedList) {
			out.println(i.toString());
		}
		out.println();
	}

}
