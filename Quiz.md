## Quick Knowledge Check

**1. Looking at this code snippet, what would be the output of the pre-order traversal?**
```java
tree.root = new Node(1);
tree.root.left = new Node(2);
tree.root.right = new Node(3);
tree.root.left.left = new Node(4);
tree.root.left.right = new Node(5);
```
A) 1 2 4 5 3 * (Correct Answer)
B) 4 2 5 1 3
C) 1 2 3 4 5
D) 4 5 2 3 1

**2. In the `Node` class implementation, what is the significance of this initialization?**
```java
left = right = null;
```
A) It's unnecessary code
B) It marks the node as a leaf node // Correct Answer - a leaf node is a terminal node with children set to null. They are the nodes at the bottom level of the tree and store actual data values
C) It creates a cycle in the tree
D) It creates a balanced tree 

**3. Fill in the blank: In an in-order traversal of a binary search tree, nodes are visited in _____ order.**
A) Random
B) Descending
C) Ascending   * (Correct Answer)
D) Level-by-level

**4. What would happen if we try to perform a pre-order traversal on this node?**
```java
Node nullNode = null;
tree.preOrderTraversal(nullNode);
```
A) NullPointerException
B) Stack overflow
C) Nothing - the method returns immediately #  (Correct Answer)
D) Prints "null"

**5. Debug this code: Why might this implementation be problematic?**
```java
public void inOrderTraversal(Node node) {
    inOrderTraversal(node.left);
    System.out.print(node.data + " ");
    inOrderTraversal(node.right);
}
```
A) It's implemented correctly
B) Missing null check - could cause NullPointerException `(Correct Answer)`
C) Wrong traversal order
D) Inefficient implementation

Would you like me to explain any of these answers or move on to more advanced concepts?