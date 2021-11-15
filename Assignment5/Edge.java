
public class Edge {
	
	Integer source;
	Integer destination;

	public Edge(Integer source, Integer destination) {
		this.source = source;
		this.destination = destination;
	}

	@Override
	public String toString() {
		return this.source + " -> " + this.destination;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Integer getDestination() {
		return destination;
	}

	public void setDestination(Integer destination) {
		this.destination = destination;
	}

}


