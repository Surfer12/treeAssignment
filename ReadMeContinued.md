# Binary Tree Traversal

## Table of Contents

1. [Understanding Binary Trees in Java](#understanding-binary-trees-in-java)
2. [Types of Trees in Java](#types-of-trees-in-java)
3. [Stack Frame Diagrams](#stack-frame-diagrams)
4. [Recursive Functions in Tree Traversal](#recursive-functions-in-tree-traversal)
5. [Applicability in Java](#applicability-in-java)
6. [Usage](#usage)

## Understanding Binary Trees in Java

A **binary tree** is a hierarchical data structure in which each node has at most two children, referred to as the left child and the right child. Binary trees are essential for various applications like searching, sorting, and representing hierarchical data.

### Node Structure

The `Node` class represents each element in the tree, containing:

- **Data**: The value stored in the node.
- **Left Child**: The reference to the left subordinate node.
- **Right Child**: The reference to the right subordinate node.

## Types of Trees in Java

Here are the main types of trees in Java, with their key characteristics:

1. **Binary Trees**

    ```java
    class BinaryNode {
        int data;
        BinaryNode left;
        BinaryNode right;
    }
    ```
    - Each node has at most 2 children

2. **Binary Search Trees (BST)**

    ```java
    class BSTNode {
        int data;
        BSTNode left;  // All values less than data
        BSTNode right; // All values greater than data
    }
    ```
    - Ordered binary tree
    - Left subtree values < node value
    - Right subtree values > node value

3. **AVL Trees**

    ```java
    class AVLNode {
        int data;
        int height;
        AVLNode left;
        AVLNode right;
    }
    ```
    - Self-balancing BST
    - Height difference between subtrees ≤ 1
    - O(log n) operations

4. **Red-Black Trees**

    ```java
    class RBNode {
        int data;
        boolean isRed;
        RBNode left;
        RBNode right;
        RBNode parent;
    }
    ```
    - Self-balancing BST
    - Nodes are red or black
    - Root and leaves (NIL) are black
    - Red nodes have black children

5. **B-Trees**

    ```java
    class BTreeNode {
        int[] keys;
        BTreeNode[] children;
        int numKeys;
        boolean isLeaf;
    }
    ```
    - Multiple keys per node
    - Used in databases and file systems
    - Balanced height

6. **Tries (Prefix Trees)**

    ```java
    class TrieNode {
        TrieNode[] children = new TrieNode[26]; // for alphabet
        boolean isEndOfWord;
    }
    ```
    - Used for string operations
    - Each node represents a character
    - Path from root forms string

7. **Heaps**

    ```java
    class BinaryHeap {
        int[] heapArray;
        int size;
    
        void heapifyUp(int index) {...}
        void heapifyDown(int index) {...}
    }
    ```
    - Complete binary tree
    - Max-heap or min-heap property
    - Implemented using arrays

Each type has specific use cases:

- **BST**: Searching and sorting
- **AVL/Red-Black Trees**: Balanced operations
- **B-Tree**: Databases
- **Trie**: String operations
- **Heap**: Priority queues

## Stack Frame Diagrams

### Binary Search Tree Stack Frame
```
     BST Stack Frame (for tree:     5    )
                                  /   \   
                                3     7   
                               / \   / \  
                              1   4 6   8 

Call Stack (grows downward):
+--------------------------+
| insert(5)                | → root node
+--------------------------+
    | insert(3)            | → less than 5, go left
    +--------------------+
        | insert(1)      | → less than 3, go left
        +--------------+
    | insert(4)          | → greater than 3, go right
    +------------------+
| insert(7)              | → greater than 5, go right
+-----------------------+
    | insert(6)          | → less than 7, go left
    +------------------+
    | insert(8)          | → greater than 7, go right
    +------------------+
```
- Recursive calls on left and right subtrees

### AVL Tree Rotation Stack Frame
```
     AVL Stack Frame (for unbalanced tree:  3   )
                                         /   \   
                                        2     4  
                                       /         
                                      1          

Call Stack (rotation):
+---------------------------+
| insert(1)                 | → triggers rebalance
+---------------------------+
    | calculateBalance(2)   | → height diff > 1
    +---------------------+
        | rotateRight(3)  | → perform rotation
        +----------------+
| updateHeight()           | → recalculate heights
+-------------------------+

Result after rotation:      2
                         /   \
                        1     3
                              \
                               4
```
- Rotations maintain balance in AVL trees

### Red-Black Tree Recolor Stack Frame
```
     RB Stack Frame (for tree:      5B     )
                                  /    \    
                                3R     7R   
                               / \    / \   
                             1B  4B  6B  8B 

Call Stack (recolor after insert):
+---------------------------+
| insert(6)                 | → new red node
+---------------------------+
    | checkColor(7)         | → parent is red
    +---------------------+
        | recolor(5)      | → recolor root
        +----------------+
    | rotate(7)           | → if needed
    +-----------------+

B = Black node
R = Red node
```
- Recoloring and rotations maintain balance

### B-Tree Insert Stack Frame
```
     B-Tree Stack Frame (order 3):     [10,20]
                                     /    |    \
                                   [5]  [15]  [25]

Call Stack (insert 12):
+--------------------------------+
| searchNode(12)                 | → find insertion point
+--------------------------------+
    | splitIfFull([15])         | → check node capacity
    +------------------------+
        | redistribute()     | → balance if needed
        +-----------------+
| updateParent()              | → update parent keys
+----------------------------+
```

### Trie Stack Frame
```
     Trie Stack Frame (for words: "CAT", "CAR")
                                root
                                 |
                                 C
                                 |
                                 A
                               /   \
                              T     R

Call Stack (insert "CAT"):
+--------------------------------+
| insert("CAT")                  | → start at root
+--------------------------------+
    | createNode('C')            | → first letter
    +------------------------+
        | createNode('A')    | → second letter
        +------------------+
            | createNode('T')| → mark as word end
            +--------------+

Call Stack (search "CAR"):
+--------------------------------+
| search("CAR")                  | → traverse from root
+--------------------------------+
    | traverse('C')              | → found
    +------------------------+
        | traverse('A')      | → found
        +------------------+
            | traverse('R') | → found, is word
            +--------------+
```

### Heap Stack Frame
```
     Heap Stack Frame (max heap):    100
                                   /    \
                                 70      90
                                /  \    /  \
                               40  35  60   80

Call Stack (insert 95):
+--------------------------------+
| insert(95)                     | → add at bottom right
+--------------------------------+
    | heapifyUp(95)              | → compare with parent
    +------------------------+
        | swap(90, 95)      | → bubble up
        +------------------+
    | updateParent()        | → maintain heap property
    +--------------------+

Result:           100
                /    \
              95      90
             /  \    /  \
            40  35  60   80
```

### Segment Tree Stack Frame
```
     Segment Tree Stack Frame (sum query):
                       [0-7]:36
                      /        \
              [0-3]:10        [4-7]:26
              /     \         /      \
        [0-1]:3  [2-3]:7  [4-5]:11  [6-7]:15

Call Stack (query sum[2,5]):
+--------------------------------+
| query(2,5)                     | → range intersection
+--------------------------------+
    | checkRange([2-3])         | → partial overlap
    +------------------------+
        | sumRange(7)        | → accumulate
        +------------------+
    | checkRange([4-5])     | → complete overlap
    +--------------------+
        | return(11)      | → add to result
        +---------------+
```

## Recursive Functions in Tree Traversal

### Pre-order Traversal

In pre-order traversal, the nodes are recursively visited in this order:

1. Visit the root node.
2. Traverse the left subtree.
3. Traverse the right subtree.

```java
void preOrderTraversal(Node node) {
    if (node == null) {
        return;
    }
    System.out.print(node.data + " ");
    preOrderTraversal(node.left);
    preOrderTraversal(node.right);
}
```

### In-order Traversal

In in-order traversal, the nodes are recursively visited in this order:

1. Traverse the left subtree.
2. Visit the root node.
3. Traverse the right subtree.

```java
void inOrderTraversal(Node node) {
    if (node == null) {
        return;
    }
    inOrderTraversal(node.left);
    System.out.print(node.data + " ");
    inOrderTraversal(node.right);
}
```

## Applicability in Java

Binary tree traversal is widely used in various applications, including:

- **Expression Trees**: Evaluating arithmetic expressions.
- **Syntax Trees**: Parsing expressions in compilers.
- **Decision Trees**: Making decisions in machine learning models.
- **Hierarchical Data**: Representing organizational structures.

## Usage

To use the binary tree traversal methods, create an instance of the `BinaryTree` class and call the traversal methods:

```java
public class BinaryTree {
    Node root;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Pre-order traversal:");
        tree.preOrderTraversal(tree.root);

        System.out.println("\nIn-order traversal:");
        tree.inOrderTraversal(tree.root);
    }

    void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }
}

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

# Binary Tree Traversal

## Overview
This project implements a binary tree and provides methods for pre-order and in-order traversal using recursive functions. 

## Recursive Functions
### Pre-order Traversal
The pre-order traversal visits the nodes in the following order:
1. Visit the root node.
2. Traverse the left subtree.
3. Traverse the right subtree.

**Time Complexity:** O(n)  
**Space Complexity:** O(h) where h is the height of the tree.

### In-order Traversal
The in-order traversal visits the nodes in the following order:
1. Traverse the left subtree.
2. Visit the root node.
3. Traverse the right subtree.

**Time Complexity:** O(n)  
**Space Complexity:** O(h) where h is the height of the tree.

## Stack Frames Diagram
A diagram illustrating the stack frames during the execution of the recursive functions can be found in the project documentation.