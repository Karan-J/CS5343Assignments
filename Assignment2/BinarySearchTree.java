
public class BinarySearchTree {
	
	public TreeNode root;

//	initialise the BinarySearchTree
	public BinarySearchTree() {
		super();
	}

//	initialise the BinarySearchTree
	public BinarySearchTree(TreeNode root) {
		super();
		this.root = root;
	}
	
//	insert a new node into the tree by a value and a reference node
	public void insertNode(TreeNode ref, int newVal) {
		if (ref == null) {
			return;
		}
		else if ( newVal < ref.val ) {
			if (ref.left != null) {
				insertNode(ref.left, newVal);
			}
			else {
				TreeNode node = new TreeNode(newVal);
				ref.left = node;
				node.left = null;
				node.right = null;
				node.parent = ref;
				return;
			}
		}
		else if ( newVal > ref.val ) {
			if ( ref.right != null ) {
				insertNode(ref.right, newVal);
			}
			else {
				TreeNode node = new TreeNode(newVal);
				ref.right = node;
				node.left = null;
				node.right = null;
				node.parent = ref;
				return;
			}
		}
	}
	
//	inOrderTraversal of the binary search tree
	public void inOrderTraversal(TreeNode temp) {
//		left, parent, right
		if (temp == null) {
			return;
		}
		inOrderTraversal(temp.left);
		System.out.printf("%d ",temp.val);
		inOrderTraversal(temp.right);
	}
	
//	get predecessor of a node by passing the val of the node whose predecessor is to be found
	public TreeNode getPredecessorOf(int predecessorNodeOf) {
		TreeNode temp = getNode(predecessorNodeOf);
		if ( temp.left != null ) {
			temp = temp.left;
			while (temp.right != null) {
				temp = temp.right;
			}
		}
		if (temp.val == predecessorNodeOf) {
			return null;
		}
		return temp;
	}

//	get successor of a node by passing the val of the node whose successor is to be found
	public TreeNode getSuccessorOf(int successorNodeOf) {
		TreeNode temp = getNode(successorNodeOf);
		if ( temp.right != null ) {
			temp = temp.right;
			while (temp.left != null) {
				temp = temp.left;
			}
		}
		if (temp.val == successorNodeOf) {
			return null;
		}
		return temp;
	}
	
//	get a node by its val
	public TreeNode getNode(int val) {
		if ( root.val == val ) {
			return root;
		}
		TreeNode temp = root;
		TreeNode parentTemp = root;
		while ( val != temp.val ) {
			if ( val < temp.val ) {
				parentTemp = temp;
				temp = temp.left;
			}
			else if (val > temp.val) { 
				parentTemp = temp;
				temp = temp.right;
			}
			else if (val == temp.val) {
				break;
			}
		}
		temp.parent = parentTemp;
		return temp;
	}
	
//	get a node's parent node
	public TreeNode getParentNode(int val) {
		return getNode(val).parent;
	}
	
//	check if a node is a leaf node or not
	public boolean isLeafNode(int val) {
		TreeNode node = getNode(val);
		if ( node.left == null && node.right == null ) {
			return true;
		}
		return false;
	}
	
//	check if a node is a left child of its parent
	public boolean isLeftChild(int val) {
		try {
			TreeNode node = getNode(val);
			if (node.val < node.parent.val) {
				return true;
			}
			return false;
		} catch (NullPointerException e) {
			System.out.println("The node is root. So it is not a child");
		}
		return false;
	}
	
//	check if a node is a right child of its parent
	public boolean isRightChild(int val) {
		return !isLeftChild(val);
	}
	
//	delete a node by its value and replace it with predecessor if possible
	public void deleteNode(int val) {
		
		System.out.println("Deleting node with val: " + val);
		TreeNode nodeToDelete = getNode(val);

//		nodeToDelete is a leaf node
		if ( isLeafNode(val) ) {
			if ( val < nodeToDelete.parent.val ) {
				nodeToDelete.parent.left = null;
			}
			else {
				nodeToDelete.parent.right = null;
			}
			return;
		}

//		nodeToDelete has 1 child
		else if ( (nodeToDelete.left != null && nodeToDelete.right == null ) || 
				(nodeToDelete.right != null && nodeToDelete.left == null) ) {

			boolean nodeToDeleteHasLeftChild = (nodeToDelete.left != null);
			
			if ( isLeftChild(nodeToDelete.val) ) {
				if ( nodeToDeleteHasLeftChild ) {
					nodeToDelete.parent.left = nodeToDelete.left;
				}
				else {
					nodeToDelete.parent.left = nodeToDelete.right;
				}
			}
			else if ( isRightChild(nodeToDelete.val) ) {
				if ( nodeToDeleteHasLeftChild ) {
					nodeToDelete.parent.right = nodeToDelete.left;
				}
				else {
					nodeToDelete.parent.right = nodeToDelete.right;
				}
			}
			
		}

//		nodeToDelete has 2 children
		else {
			
			TreeNode predecessor = getPredecessorOf(val);
			System.out.println("Replacing the node with predecessor having val: " + predecessor.val);
			boolean predecessorHasLeftChild = (predecessor.left != null);
			
//			if predecessor has a left sub-tree
			if ( !isLeafNode(predecessor.val) ) {
//				predecessor will always have a left sub-tree/child since if it had a right sub-tree/child, it wouldn't have been the predecessor and
//				its right child would have been the predecessor. or it will be a leaf node

//				link predecessor's child to its parent
				if ( predecessorHasLeftChild ) {
					predecessor.parent.right = predecessor.left;
					predecessor.left.parent = predecessor.parent;
				}  
			}

//			predecessor is a leaf node
			else {
				
//				unlink the predecessor from its parent
				if ( isLeftChild(predecessor.val) ) {
					predecessor.parent.left = null;
				}
				else {
					predecessor.parent.right = null;
				}
				
//				relink predecessor to nodeToDelete's parent
				predecessor.parent = nodeToDelete.parent;
				if ( isLeftChild(nodeToDelete.val) ) {
					nodeToDelete.parent.left = predecessor;
				}
				else {
					// nodeToDelete is a right child
					nodeToDelete.parent.right = predecessor;
				}
				
//				relink nodeToDelete's children with predecessor
				if (nodeToDelete.right != null ) {
					predecessor.right = nodeToDelete.right;
				}
				if (nodeToDelete.left != null ) {
					predecessor.left = nodeToDelete.left;
				}
				
			}

//			make predecessor as parent of nodeToDelete's children's parent
			nodeToDelete.left.parent = predecessor;
			nodeToDelete.right.parent = predecessor;
			nodeToDelete.val = predecessor.val;
			
			return;
		}
		
	}

}
