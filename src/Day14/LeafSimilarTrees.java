package Day14;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	/**
	 * Default constructor.
	 */
	TreeNode() {
	}

	/**
	 * Constructor to initialize the node with a value.
	 * 
	 * @param val The value of the node.
	 */
	TreeNode(int val) {
		this.val = val;
	}

	/**
	 * Constructor to initialize the node with value and left/right children.
	 * 
	 * @param val   The value of the node.
	 * @param left  The left child node.
	 * @param right The right child node.
	 */
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

/**
 * This class provides a method to check whether two binary trees are leaf-similar.
 * Two binary trees are considered leaf-similar if their leaf value sequences are the same.
 */
public class LeafSimilarTrees {

	/**
	 * Checks if the leaf sequences of two binary trees are identical.
	 * 
	 * @param root1 The root node of the first tree.
	 * @param root2 The root node of the second tree.
	 * @return {@code true} if both trees have the same leaf value sequence; {@code false} otherwise.
	 */
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		createLeaf(root1, list1);
		createLeaf(root2, list2);

		if (list1.size() != list2.size())
			return false;

		for (int i = 0; i < list1.size(); i++) {
			if (!list1.get(i).equals(list2.get(i)))
				return false;
		}
		return true;
	}

	/**
	 * Populates the list with the leaf values from the binary tree.
	 * 
	 * @param root The current node of the binary tree.
	 * @param list The list to store leaf values.
	 */
	public static void createLeaf(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			list.add(root.val);
			return;
		}
		createLeaf(root.left, list);
		createLeaf(root.right, list);
	}

	/**
	 * Prints the in-order traversal of the given binary tree.
	 * 
	 * @param root The root of the binary tree.
	 */
	private void printInorderBST(TreeNode root) {
		if (root != null) {
			printInorderBST(root.left);
			System.out.print(root.val + " ");
			printInorderBST(root.right);
		}
	}

	/**
	 * Main method to demonstrate the leafSimilar method with two example binary trees.
	 * 
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		LeafSimilarTrees solution = new LeafSimilarTrees();

		// Construct first binary tree
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(5);
		root1.left.left = new TreeNode(6);
		root1.left.right = new TreeNode(2);
		root1.left.right.left = new TreeNode(7);
		root1.left.right.right = new TreeNode(4);
		root1.right = new TreeNode(1);
		root1.right.left = new TreeNode(9);
		root1.right.right = new TreeNode(8);

		System.out.print("In-order traversal of the Root1 BST: ");
		solution.printInorderBST(root1);
		System.out.println();

		// Construct second binary tree
		TreeNode root2 = new TreeNode(3);
		root2.left = new TreeNode(5);
		root2.left.left = new TreeNode(6);
		root2.left.right = new TreeNode(7);
		root2.right = new TreeNode(1);
		root2.right.left = new TreeNode(4);
		root2.right.right = new TreeNode(2);
		root2.right.right.left = new TreeNode(9);
		root2.right.right.right = new TreeNode(8);

		System.out.print("In-order traversal of the Root2 BST: ");
		solution.printInorderBST(root2);
		System.out.println();

		// Check if trees are leaf-similar
		boolean result = solution.leafSimilar(root1, root2);
		System.out.println("Are the two trees leaf-similar? " + result);
	}
}
