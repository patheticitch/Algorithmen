package alg.a03;

public class Node {
	private Vertex vertex;
	private Vertex pred;
	private  int dist;
	
	public Node (Vertex v,Vertex pred,int d) {
		this.vertex=v;
		this.dist=d;
		this.pred=pred;
	}
	
	public Vertex getVertex() {
		return this.vertex;
	}
	
	
}
