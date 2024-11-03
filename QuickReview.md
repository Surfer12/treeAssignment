Quick review : Preoder, Inorder, and Postorder Traversal of a Binary Tree

Use cases for pre-order, in-order, and post-order traversal of a binary tree.
Pre-order, in-order, and post-order traversal are three common ways to visit all nodes in a binary tree. Each traversal method has its own use cases and can be implemented using recursion or iteration.

## Pre-order Traversal
In pre-order traversal, the root node is visited first, followed by the left subtree and then the right subtree. 

The pre-order traversal of a binary tree is useful for creating a copy of the tree, evaluating expressions, and prefix notation in mathematical expressions.

Here is an example of pre-order traversal in Java using recursion:

```java
class Node {
    int data;
    Node left, right;
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;
    public void preOrderTraversal(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
}
```

## In-order Traversal
In in-order traversal, the left subtree is visited first, followed by the root node, and then the right subtree.

The in-order traversal of a binary tree is useful for printing the nodes of the tree in sorted order, evaluating expressions, and infix notation in mathematical expressions.

Here is an example of in-order traversal in Java using recursion:

```java
class BinaryTree {
    Node root;
    public void inOrderTraversal(Node node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }
}
```

## Post-order Traversal
In post-order traversal, the left subtree is visited first, followed by the right subtree, and then the root node.

The post-order traversal of a binary tree is useful for deleting the tree, evaluating expressions, and postfix notation in mathematical expressions.

Here is an example of post-order traversal in Java using recursion:

```java
class BinaryTree {
    Node root;
    public void postOrderTraversal(Node node) {
        if (node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }
}
```

In addition to the recursive implementations shown above, iterative implementations of these traversal methods can also be done using a stack data structure.

Itreative implementation of pre-order traversal:
```java
public void preOrderTraversal(Node root) {
    if (root == null) return;
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        Node node = stack.pop();
        System.out.print(node.data + " ");
        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left);
    }
}
```

Iterative implementation of in-order traversal:
```java
public void inOrderTraversal(Node root) {
    if (root == null) return;
    Stack<Node> stack = new Stack<>();
    Node current = root;
    while (current != null || !stack.isEmpty()) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        current = stack.pop();
        System.out.print(current.data + " ");
        current = current.right;
    }
}
```

Iterative implementation of post-order traversal:
```java
public void postOrderTraversal(Node root) {
    if (root == null) return;
    Stack<Node> stack1 = new Stack<>();
    Stack<Node> stack2 = new Stack<>();
    stack1.push(root);
    while (!stack1.isEmpty()) {
        Node node = stack1.pop();
        stack2.push(node);
        if (node.left != null) stack1.push(node.left);
        if (node.right != null) stack1.push(node.right);
    }
    while (!stack2.isEmpty()) {
        System.out.print(stack2.pop().data + " ");
    }
}
```

These traversal methods are fundamental to understanding binary trees and are used in a variety of algorithms and applications.

