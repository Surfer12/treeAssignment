# Trees in Java

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
class BST {
    int data;
    BST left;  // All values less than data
    BST right; // All values greater than data
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

6. **Trie (Prefix Tree)**
```java
class TrieNode {
    TrieNode[] children = new TrieNode[26]; // for alphabet
    boolean isEndOfWord;
}
```
- Used for string operations
- Each node represents a character
- Path from root forms string

7. **Heap**
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
- BST: Searching and sorting
- AVL/Red-Black: Balanced operations
- B-Tree: Databases
- Trie: String operations
- Heap: Priority queues


