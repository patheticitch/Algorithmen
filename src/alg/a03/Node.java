package alg.a03;

public class Node {
	private Vertex vertex;
	private Vertex pred;
	protected  int dist;
	
	public Node (Vertex v,Vertex pred,int d) {
		this.vertex=v;
		this.dist=d;
		this.pred=pred;
	}
	
	public Vertex getVertex() {
		return this.vertex;
	}
	
	public Vertex getPred() {
		return this.pred;
	}
	
	public String toString() {
		if(this.pred==null) {
			return String.format("vertex: %s pred: %s dist: %d", this.vertex.toString(),"null",this.dist);
		}
		return String.format("vertex: %s pred: %s dist: %d ", this.vertex.toString(),this.pred.toString(),this.dist);
	}
	
}
