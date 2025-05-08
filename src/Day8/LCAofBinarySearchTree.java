package Day8;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class LCAofBinarySearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;

		if (root == p || root == q)
			return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left == null)
			return right;

		if (right == null)
			return left;

		return root;
	}

	public static void main(String[] args) {
		LCAofBinarySearchTree solution = new LCAofBinarySearchTree();

		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);

		TreeNode p = root.left;
		TreeNode q = root.left.right;

		TreeNode lca = solution.lowestCommonAncestor(root, p, q);

		System.out.println("The LCA of " + p.val + " and " + q.val + " is: " + lca.val);
	}
}