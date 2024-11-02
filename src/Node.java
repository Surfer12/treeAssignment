package binary.tree.traversal;
public class Node {
    int data;      // The value or data stored in the node
    Node left;     // Reference to the left child node
    Node right;    // Reference to the right child node

    // Constructor to initialize the node with data and null child nodes
    public Node(int data) {
        this.data = data;
        left = right = null; // Initially, the node has no children
    }
}