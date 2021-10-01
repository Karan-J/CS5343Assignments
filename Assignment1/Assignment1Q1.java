
public class Assignment1Q1 {
	
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
//		first 10 values
		list.addNodeToList(1);
		list.addNodeToList(5);
		list.addNodeToList(8);
		list.addNodeToList(2);
		list.addNodeToList(9);
		list.addNodeToList(25);
		list.addNodeToList(4);
		list.addNodeToList(7);
		list.addNodeToList(6);
		list.addNodeToList(10);
		
//		next 5 values
		list.addNodeToList(12);
		list.addNodeToList(67);
		list.addNodeToList(16);
		list.addNodeToList(49);
		list.addNodeToList(24);
		
		System.out.println("Before sorting the linked list");
		list.displayList();
		
//		performing selection sort by swapping nodes
		list.selectionSort();
		
		System.out.println("After performing selection sort");
		list.displayList();
		
	}

}
