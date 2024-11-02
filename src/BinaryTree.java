package binary.tree.traversal;
public class BinaryTree {
    Node root;

    public void preOrderTraversal(Node node) {
        if (node == null) return;
        System.out.print(node.data + " "); // Process the current node
        preOrderTraversal(node.left);      // Recursively traverse left subtree
        preOrderTraversal(node.right);     // Recursively traverse right subtree
    }

    public void inOrderTraversal(Node node) {
        if (node == null) return;
        inOrderTraversal(node.left);       // Recursively traverse left subtree
        System.out.print(node.data + " "); // Process the current node
        inOrderTraversal(node.right);      // Recursively traverse right subtree
    }
}