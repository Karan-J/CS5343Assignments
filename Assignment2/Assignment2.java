
public class Assignment2 {

	public static void main(String[] args) {

		// insert these nodes in the binary search tree:
		// 40 60 20 80 50 10 30 15 5 35 25 45 55 70 90 32 33 48 46
		//
		// do inorder traversal
		// delete 40. decide predecessor
		// do inorder traversal again
		// delete 20. decide predecessor
		// do inorder traversal again

		// creating the root node
		TreeNode root = new TreeNode(40);

		// initialising the binary search tree
		BinarySearchTree binarySearchtree = new BinarySearchTree(root);
		binarySearchtree.insertNode(root, 60);
		binarySearchtree.insertNode(root, 20);
		binarySearchtree.insertNode(root, 80);
		binarySearchtree.insertNode(root, 50);
		binarySearchtree.insertNode(root, 10);
		binarySearchtree.insertNode(root, 30);
		binarySearchtree.insertNode(root, 15);
		binarySearchtree.insertNode(root, 5);
		binarySearchtree.insertNode(root, 35);
		binarySearchtree.insertNode(root, 25);
		binarySearchtree.insertNode(root, 45);
		binarySearchtree.insertNode(root, 55);
		binarySearchtree.insertNode(root, 70);
		binarySearchtree.insertNode(root, 90);
		binarySearchtree.insertNode(root, 32);
		binarySearchtree.insertNode(root, 33);
		binarySearchtree.insertNode(root, 48);
		binarySearchtree.insertNode(root, 46);

		System.out.println("----- Inorder Traversal -------");
		binarySearchtree.inOrderTraversal(root);
		System.out.println();
		
//		deleting node with val 40
		binarySearchtree.deleteNode(40);
		System.out.println("----- Inorder Traversal -------");
		binarySearchtree.inOrderTraversal(root);
		System.out.println();
		
//		deleting node with val 20
		binarySearchtree.deleteNode(20);
		System.out.println("----- Inorder Traversal -------");
		binarySearchtree.inOrderTraversal(root);
		System.out.println();
		
	}

}
