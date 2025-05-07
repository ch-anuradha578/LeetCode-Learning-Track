package Day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> preorder = new ArrayList<Integer>();

		if (root == null)
			return preorder;

		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);

		while (!st.isEmpty()) {
			root = st.pop();
			preorder.add(root.val);

			if (root.right != null) {
				st.push(root.right);
			}
			if (root.left != null) {
				st.push(root.left);
			}
		}
		return preorder;
	}

	public static void main(String[] args) {
		BinaryTreePreorderTraversal solution = new BinaryTreePreorderTraversal();

		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;

		List<Integer> preorder = solution.preorderTraversal(node1);
		System.out.println("Binary Tree Preorder Traversal: " + preorder);
	}
}
