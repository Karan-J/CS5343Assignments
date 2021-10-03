
public class TreeNode {
	
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	
	public TreeNode() {
		super();
	}

	public TreeNode(int val) {
		super();
		this.val = val;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", parent = " + parent +"]";
	}

}
