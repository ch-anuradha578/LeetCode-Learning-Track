package Day12;

/**
 * Represents a node in a binary search tree (BST).
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	/**
	 * Default Constructor.
	 */
	TreeNode() {
	}

	/**
	 * Constructs a TreeNode with a value.
	 * 
	 * @param val The value of the node.
	 */
	TreeNode(int val) {
		this.val = val;
	}

	/**
	 * Constructs a TreeNode with a value and left and right children.
	 * 
	 * @param val   The value of the node.
	 * @param left  The left child.
	 * @param right The right child.
	 */
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

/**
 * A class to find the minimum absolute distance between values of any two nodes
 * in a Binary Search Tree (BST).
 */

public class MinimumDistanceBetweenBSTNodes {
	TreeNode prev = null;
	int min = Integer.MAX_VALUE;

	/**
	 * Computes the minimum difference between any two nodes in the BST.
	 * 
	 * @param root The root of the BST.
	 * @return The minimum absolute difference between any two nodes values.
	 */
	public int minDiffInBST(TreeNode root) {
		inOrder(root);
		return min;
	}

	/**
	 * Performs an in-order traversal of the BST while computing the minimum
	 * difference.
	 * 
	 * @param root The root of the BST.
	 */
	public void inOrder(TreeNode root) {
		if (root == null)
			return;

		inOrder(root.left);
		if (prev != null) {
			min = Math.min(min, root.val - prev.val);
		}
		prev = root;
		inOrder(root.right);
	}

	/**
	 * Prints the in-order traversal of the BST.
	 * 
	 * @param root The root of the BST.
	 */
	private void printInorderBST(TreeNode root) {
		if (root != null) {
			printInorderBST(root.left);
			System.out.print(root.val + " ");
			printInorderBST(root.right);
		}
	}

	/**
	 * Main method to test the functionality.
	 * 
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		MinimumDistanceBetweenBSTNodes solution = new MinimumDistanceBetweenBSTNodes();

		// Construct the BST
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(6);

		System.out.print("In-order traversal of the BST: ");
		solution.printInorderBST(root);
		System.out.println();

		int result = solution.minDiffInBST(root);
		System.out.println("Maximum distance between BST Nodes: " + result);
	}
}
