package alg.a03;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	private Graph<Vertex, Edge<Vertex>> graph;
	public LinkedList<Vertex> visitedList;
	public Queue<Vertex> queue;

	public BFS(Graph<Vertex, Edge<Vertex>> graph) {
		this.graph = graph;
		this.queue = new LinkedList<Vertex>();
		this.visitedList = new LinkedList<Vertex>();
	}

	public void BreadthSearch(int start, int end) {
		Vertex first = graph.getVertex(start);
		Vertex last = graph.getVertex(end);
		queue.add(first);
		while (!queue.isEmpty()) {
			if (first.equals(last)) {
				break;
			}
			Vertex dequeueVertex = queue.poll();
			if (dequeueVertex.equals(last)) {
				visitedList.add(last);
				System.out.println("found " + last);
				break;
			}
			getNeighbors(dequeueVertex);
		}

	}

	public void addToVisited(Vertex v) {
		if (!isVisited(v)) {
			visitedList.add(v);
		}
	}

	public void getNeighbors(Vertex v) {
		addToVisited(v);
		Collection<Vertex> neighbors = graph.getNeighbours(v);
		Iterator<Vertex> nIt = neighbors.iterator();
		while (nIt.hasNext()) {
			Vertex nextVertex = nIt.next();
			if (!isVisited(nextVertex)) {
				queue.add(nextVertex);
			}

		}
	}

	public boolean isVisited(Vertex v) {
		if (visitedList.contains(v)) {
			// System.out.println("contains "+v);
			return true;
		}
		return false;
	}

	public void printSearch(PrintWriter out) {
		for (Vertex i : visitedList) {
			out.print(i + " ");
		}
		out.println();
	}

}
