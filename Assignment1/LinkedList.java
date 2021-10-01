
public class LinkedList {
	
	public Node head;
	public Node tail;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public void addNodeToList(int val) {
		/** add a node to the linkedlist **/
		
		Node newNode = new Node(val);
		
//		if there is no head, make the newNode as the head and tail
		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public void displayList() {
		/** prints out the linkedlist **/
		String s = "" + head.val;
		Node temp = head;
		while(temp.getNext() != null) {
			temp = temp.getNext();
			s = s + ", " + temp.getVal();
		}
		System.out.println(s);
	}
	
	public void displayDetailedList() {
		/** prints out the linkedlist with head and tail labels**/
		String s = "[head]: " + head.val;
		Node temp = head;
		while(temp.getNext().getNext() != null) {
			temp = temp.getNext();
			s = s + ", " + temp.getVal();
		}
		s = s + ", [tail]: " + tail.getVal();
		System.out.println(s);
	}
	
	public Node getNode(int value) {
		/** get a specific node by its value **/
		Node node = head;
		if (node == null) {
			throw new IllegalStateException("Empty linked-list");
		}
		if (tail.val == value) {
			return tail;
		}
		while (node.val != value && node.next != null) {
			node = node.next;
		}
		return node;
	}
	
	public void swapNodes(int val1, int val2) {
		/** swap the two nodes of the linkedlist **/
		
		System.out.println("Swap val1 = " + val1 + " and val2 = " + val2);
		
		Node n1 = head;
		Node n2 = head;
		Node n1Previous = null;
		Node n2Previous = null;
		Node temp1 = head;
		Node temp2 = head;
		
//		if the two values are equal, no swapping
		if (val1 == val2) {
			System.out.println("Equal values, so no swapping");
			displayList();
			return;
		}
		
//		reaching the node n1 to be swapped and its previous node n1Previous
		while (temp1.val != val1 && temp1 != null) {
			n1Previous = temp1;
			temp1 = temp1.next;
			n1 = temp1;
		}
		
		System.out.println("n1 = " + n1.val + ", n1Previous = " + n1Previous);
		
//		reaching the node n2 to be swapped and its previous node n2Previous
		while (temp2.val != val2  && temp2 != null) {
			n2Previous = temp2;
			temp2 = temp2.next;
			n2 = temp2;
		}

		System.out.println("n2 = " + n2.val + ", n2Previous = " + n2Previous);
		
//		if the node to be swapped has no previous node, the new node would be the head node
		if (n1Previous == null) {
			head = n2;
		} else {
//			the next node of previous-node of n1 will now be n2 
			n1Previous.next = n2;
		}
		
//		if the node to be swapped has no previous node, the new node would be the head node
		if (n2Previous == null) {
			head = n1;
		} else {
//			the next node of previous-node of n2 will now be n1
			n2Previous.next = n1;
		}
		
//		finally swapping n1 and n2
		temp1 = n1.next;
		n1.next = n2.next;
		n2.next = temp1;
		
//		printing out the list with the swapped values
		displayList();
	}
	
	
	public void selectionSort() {
		/** sort the linkedlist by swapping values **/
		Node n1 = null;
		Node n2 = null;
		n1 = head;
		
//		integer because using a Node here updates the references of n1.
//		keeping it as integer as we only want to compare the value
		int minimum = n1.val;
		
		while (n1 != null) {
			minimum = n1.val;
			n2 = n1.next;
			while (n2 != null) {
				if (n2.val <= minimum) {
//					storing only the integer value of the minimum node
					minimum = n2.val;
				}
				n2 = n2.next;
			}
			
//			swap the minimum-valued node in the unsorted list with the current-node
			swapNodes(n1.val,minimum);
			
//			after swapping n1 and n2 (minimum), we get them as n2 (minimum) and n1.
//			thus we have to update n1 as n2.next and not as n1.next
//			if we update n1 as n1.next, the values between n1 and n2 won't be sorted
			n1 = getNode(minimum).next;
		}
	}
	

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

}
