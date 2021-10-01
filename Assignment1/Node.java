
public class Node {
	
	public int val;
	public Node next;
	
	public Node() {
		super();
		val = Integer.MIN_VALUE;
		this.next = null;
	}
	
	public Node(int val) {
		super();
		this.val = val;
		this.next = null;
	}
	
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [val=" + val + "]";
	}
	

}
