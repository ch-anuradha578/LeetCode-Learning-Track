package Day15;

/**
 * TreeNode class represents a node in a binary search tree (BST).
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
     * Constructor to create a node with a specific value.
     *
     * @param val The value of the node.
     */
    TreeNode(int val) {
        this.val = val;
    }

    /**
     * Constructor to create a node with a specific value, left child, and right child.
     *
     * @param val   The value of the node.
     * @param left  The left child of the node.
     * @param right The right child of the node.
     */
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * This class provides the solution to delete a node from a Binary Search Tree (BST).
 * The node can have 0, 1, or 2 children, and the method handles all these cases.
 */
public class DeleteNodeInBST {

    /**
     * Deletes a node from the Binary Search Tree (BST) with the given key.
     * 
     * @param root The root of the BST.
     * @param key  The value of the node to be deleted.
     * @return The root of the modified BST after the node is deleted.
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        //If the root is null, return null.
        if (root == null)
            return null;

        // If the key to delete is smaller than the root's value, go to the left subtree.
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        
        // If the key to delete is greater than the root's value, go to the right subtree.
        else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        
        // If root's value is equal to the key to delete.
        else if (root.right != null && root.left != null) {
            // If the node to be deleted has two children, find the maximum value from the left subtree.
            int maxVal = findMax(root.left, Integer.MIN_VALUE);
            root.val = maxVal;
            root.left = deleteNode(root.left, maxVal); // Delete the node with the maximum value.
            return root;
        }
        
        // If the node has only one child (left child), return the left child.
        else if (root.left != null) {
            return root.left;
        }
        
        // If the node has only one child (right child), return the right child.
        else if (root.right != null) {
            return root.right;
        }
        
        // If the node has no children, return null to delete the node.
        else {
            return null;
        }

        return root;
    }

    /**
     * Finds the maximum value in the left subtree of the given node.
     * This helper method is used to find the in-order predecessor when deleting a node with two children.
     *
     * @param root The root of the subtree to find the maximum value.
     * @param max  The current maximum value.
     * @return The maximum value found in the left subtree.
     */
    private static int findMax(TreeNode root, int max) {
        while (root != null) {
            max = Math.max(max, root.val);
            root = root.right; // Move right to find the maximum.
        }
        return max;
    }

    /**
     * Prints the in-order traversal of the given binary tree. In-order traversal means visiting the
     * left subtree, then the node, and then the right subtree.
     *
     * @param root The root of the binary tree.
     */
    private void printInorderBST(TreeNode root) {
        if (root != null) {
            printInorderBST(root.left); // Traverse the left subtree.
            System.out.print(root.val + " "); // Print the node value.
            printInorderBST(root.right); // Traverse the right subtree.
        }
    }

    /**
     * Main method to demonstrate the deleteNode method by constructing a BST, deleting a node, and
     * printing the in-order traversal before and after deletion.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        DeleteNodeInBST solution = new DeleteNodeInBST();

        // Construct a sample binary search tree.
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.right = new TreeNode(6);
        root1.right.right = new TreeNode(7);

        // Print the in-order traversal before deletion.
        System.out.print("In-order traversal of the Root BST: { ");
        solution.printInorderBST(root1);
        System.out.println("}");

        // Specify the key to delete.
        int key = 3;

        System.out.println("Key to delete Node: " + key);
        
        // Perform the delete operation.
        TreeNode result = solution.deleteNode(root1, key);
        
        // Print the in-order traversal after deletion.
        System.out.print("BST After delete particular node: { ");
        solution.printInorderBST(result);
        System.out.println("}");
    }
}
