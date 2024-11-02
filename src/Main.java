package binary.tree.traversal;
public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Construct the binary tree manually
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        tree.root = new Node(1);             // Root node
        tree.root.left = new Node(2);        // Left child of root
        tree.root.right = new Node(3);       // Right child of root
        tree.root.left.left = new Node(4);   // Left child of node 2
        tree.root.left.right = new Node(5);  // Right child of node 2

        // Perform pre-order traversal (Root -> Left -> Right)
        // Expected output: 1 2 4 5 3
        System.out.println("Pre-order Traversal:");
        tree.preOrderTraversal(tree.root);

        // Perform in-order traversal  (Left -> Root -> Right) 
        // Expected output: 4 2 5 1 3
        System.out.println("\nIn-order Traversal:");
        tree.inOrderTraversal(tree.root);
    }
}