package Day7;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean checkBST(TreeNode node, long min, long max) {
		if (node == null)
			return true;
		if (node.val <= min || node.val >= max)
			return false;

		if (checkBST(node.left, min, node.val) && checkBST(node.right, node.val, max)) {
			return true;
		}
		return false;
	}

	private void printPreOrderBST(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			printPreOrderBST(root.left);
			printPreOrderBST(root.right);
		}
	}

	public static void main(String[] args) {
		ValidateBinarySearchTree solution = new ValidateBinarySearchTree();

		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(6);
		root.right = new TreeNode(10);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(15);

		System.out.print("In-order traversal of the tree: ");
		solution.printPreOrderBST(root);
		System.out.println();

		boolean result = solution.isValidBST(root);
		System.out.println("Is the tree a valid BST? " + result);
	}
}
