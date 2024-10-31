package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeNode {

    /**
     *
     * Trees:
     *
     * NB: elements can be interchanged with nodes
     * A tree is a data structure similar to a linked list but instead of each element pointing to the next element, each element points to a number of elements.
     * It is an example of a non-linear data structure. A tree structure is a way of representing the hierarchy of a structure in a graphical form.
     * It is named a "tree structure" because the classic representation resembles a tree, even though the chart is generally upside down compared to an actual tree, with the "root" at the top and the "leaves" at the bottom.
     * in trees ADT, the order of the elements is not important.
     *
     *
     * Glossary:
     * 1. Root: The top node in a tree. It is the node with no parent.
     * 2. Edge: The link between two nodes (i.e parent to child).
     * 3. Leaf: A node with no children.
     * 4. Sibling: Nodes with the same parent.
     * 5. Ancestor: A node p is an ancestor of node q if there exists a path from the root to q that includes p.
     * 6. Descendant: A node q is a descendant of node p if there exists a path from p to q.
     * 7. Level of a node: The level of a node is the number of edges on the path from the root to the node. The set of all nodes at a particular depth is the level of the tree.
     * 8. Depth of a node: The depth of a node is the number of edges on the path from the root to the node. It is the length of the path from the root to the node.
     * 9. Height of a node: The height of a tree is the number of edges on the longest path from the root to a leaf.
     * 10. Height of a tree: The height of a tree is the height of the root node. It is the maximum height among all nodes in the tree.
     * 11. Depth of a tree: The depth of a tree is the depth of the root node. It is the maximum depth among all nodes in the tree.
     * 12. Size of a node: The size of a node is the number of nodes in the subtree rooted at the node.
     * 13. Size of a tree: The size of a tree is the number of nodes in the tree.
     * 14. Subtree: A tree formed by a node and all its descendants.
     * 15. Skew tree: A tree in which every internal node has exactly one child.
     *
     *
     * Binary Tree:
     * A tree is called a binary tree if each node has zero child, one child or two children. An empty tree is also a valid binary tree.
     * We can visualise a binary tree as consisting of a root and two disjoint binary trees, called the left and right subtrees of the root.
     *
     * Types of Binary Trees:
     * 1. Strict Binary Trees: A binary tree is called a strict binary tree if each node has exactly two children or no children. It is also called a proper or perfect binary tree.
     * 2. Full Binary Tree: A binary tree is called a full binary tree if each node has exactly two children and all leaf nodes are at the same level.
     * 3. Complete Binary Tree: A binary tree is called a complete binary tree if all leaf nodes are at height n or n - 1 and also without any missing number in the sequence.
     *
     * NB: Every strict binary tree is a full binary tree.
     * NB: Not every full binary tree is a strict binary tree.
     *
     *
     * Properties of Binary Trees:
     *      For the following properties, n is the number of nodes in the binary tree. Also let us assume that root node is at height 0.
     *
     *      1. The maximum number of nodes n in a full binary tree is 2^(h + 1) - 1, where h is the height of the tree.
     *      2 The number of nodes n in a complete binary tree is between 2^h (minimum) and 2^(h + 1) - 1 (maximum), where h is the height of the tree.
     *      3. The number of leaf nodes in a full binary tree is 2^h, where h is the height of the tree.
     *      4. The number of NULL links (wasted pointers) in a complete binary tree of n nodes is n + 1.
     *
     *
     * Structure of Binary Trees:
     *    Look at the code below for the structure of a binary tree.
     *
     *
     * Operations on Binary Trees:
     * - Basic Operations:
     *     1. Insertion: Insert an element into the binary tree.
     *     2. Deletion: Delete an element from the binary tree.
     *     3. Searching: Search for an element in the binary tree.
     *     4. Traversal: Traverse the binary tree in different ways.
     *
     * - Auxiliary Operations:
     *    1. Height: Find the height of the binary tree.
     *    2. Size: Find the number of nodes in the binary tree.
     *    3. Finding the level which has the maximum sum.
     *    4. Finding the least common ancestor (LCA) for a given pair of nodes.
     *    5. Finding the maximum element in the binary tree.
     *    6. Finding the minimum element in the binary tree.
     *    7. Finding the kth smallest element in the binary tree.
     *    and many more...
     *
     *
     * Applications of Binary Trees:
     * 1. Expression trees: Binary trees are used to represent expressions. They are used in compilers to convert expressions into machine code.
     * 2. Binary Search Trees: Binary trees are used to implement binary search trees. They are used in databases to store and retrieve records efficiently. it does this in O(log n) time.
     * 3. Huffman coding: Binary trees are used in Huffman coding to compress data.
     * 4. Priority queues: Binary trees are used to implement priority queues. It supports search and deletion of minimum and maximum elements in O(log n) time.
     */

    public int data;
    public BinaryTreeNode left, right;

    public BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }


    /**
     * Binary Tree Traversals:
     *
     * Traversal is the process of visiting all the nodes of a tree and may print their values too. Each node is processed only once but it may be visited multiple times.
     * Tree traversal is like searching the tree, except that in traversal the goal is to move through the tree in a particular order.
     * In addition, all nodes are processed in the traversal but searching stops when the required node (target) is found.
     *
     *
     * Traversal Possibilities:
     * Starting at the root of a binary tree, there are three main steps that can be performed and the order in which they are performed determines the type of traversal.
     * The three steps are:
     * 1. Visit the root node. You are performing an operation on the node. Denoted by D.
     * 2. Traversing to the left child. Denoted by L.
     * 3. Traversing to the right child. Denoted by R.
     *
     * These process can be easily described through recursion.
     *  1. LDR: Process the left subtree, process the current node data and then process the right subtree.
     *  2. LRD: Process the left subtree, process the right subtree and then process the current node data.
     *  3. DLR: Process the current node data, process the left subtree and then process the right subtree.
     *  4. DRL: Process the current node data, process the right subtree and then process the left subtree.
     *  5. RDL: Process the right subtree, process the current node data and then process the left subtree.
     *  6. RLD: Process the right subtree, process the left subtree and then process the current node data.
     *
     *
     * Classifying the Traversals:
     *  The sequence in which these entities (nodes) are processed defines a particular traversal method. The classification is based on the order in which the current node is processed.
     *  That means, if we are classifying based on current node (D), then we have three types of traversals:
     *      - Preorder Traversal: DLR
     *      - Inorder Traversal: LDR
     *      - Postorder Traversal: LRD
     *      - Level Order Traversal: Traverse the tree level by level.
     *
     *
     *  Preorder Traversal:
     * In preorder traversal, each node is processed before (pre) either of its subtrees. This is the simplest traversal to understand and implement.
     * However, even though each node is processed before the subtrees, it still requires that some information must be maintained while moving down the tree.
     * Therefore, processing must return to the right subtree after finishing the processing of the left subtree. To move back to the right subtree, the information must be stored.
     * This information is stored in the form of a stack.
     * Due to the LIFO structure, it is possible to get the information about the right subtree back in the reverse order.
     *
     * Preorder Traversal Algorithm:
     * 1. Visit the root node.
     * 2. Traverse the left subtree in preorder.
     * 3. Traverse the right subtree in preorder.
     *
     * Preorder Traversal Example:
     * Let's consider the following binary tree:
     *        1
     *       / \
     *      2   3
     *     / \ / \
     *     4 5 6 7
     *     The preorder traversal of the above binary tree is: 1 2 4 5 3 6 7
     *  Time Complexity: O(n)
     *  Space Complexity: O(h), where h is the height of the binary tree.
     *
     *  Iterative Preorder Traversal:
     *
     *  In the recursive version, a stack is required as we need to remember the current node so that after completing the left tree we can go to the right subtree
     *  To simulate the same, first we process the current node and before going to the left subtree, we store the current node on stack.
     *  After completing the left subtree processing , pop the element and go to its right tree. Continue this process until the stack is nonempty.
     *
     *  Algorithm:
     *  1. Create a stack to store the nodes.
     *  2. Push the root node to the stack.
     *  3. While the stack is not empty, do the following:
     *    - Pop the top node from the stack and process it.
     *    - If the right child of the popped node is not null, push it to the stack.
     *    - If the left child of the popped node is not null, push it to the stack.
     *  4. Continue the process until the stack is empty.
     *
     *  Time Complexity: O(n)
     *  Space Complexity: O(h), where h is the height of the binary tree.
     *
     *
     *
     *
     *  Inorder Traversal:
     *
     *  In Inorder Traversal the root is visited between the subtrees (left and right). Inorder traversal is defined as follows:
     *     - Traverse the left subtree in inorder.
     *     - Visit the root node.
     *     - Traverse the right subtree in inorder.
     *
     * Inorder Traversal Example:
     * Let's consider the following binary tree:
     *       1
     *      / \
     *     2   3
     *    / \ / \
     *    4 5 6 7
     *    The inorder traversal of the above binary tree is: 4 2 5 1 6 3 7
     *
     *   Time Complexity: O(n)
     *   Space Complexity: O(h), where h is the height of the binary tree.
     *
     *
     * Non-Recursive (Iterative) Inorder Traversal:
     *
     * The Non-Recursive Inorder Traversal is similar to the iterative preorder traversal. The only difference is that the processing of the current node is done in the middle.
     * You process the node after popping (which is indicated after completing the left subtree processing).
     *
     * Algorithm:
     * 1. Create a stack to store the nodes.
     * 2. Push the root node to the stack.
     * 3. While the stack is not empty, do the following:
     *   - Traverse the left subtree and push the nodes to the stack.
     *   - Pop the top node from the stack and process it.
     *   - Traverse the right subtree.
     *   - Continue the process until the stack is empty.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(h), where h is the height of the binary tree.
     *
     *
     *
     *
     * Postorder Traversal:
     *
     * In Postorder Traversal, the root is visited after the subtrees (left and right). Postorder traversal is defined as follows:
     *   - Traverse the left subtree in postorder.
     *   - Traverse the right subtree in postorder.
     *   - Visit the root node.
     *
     *   Postorder Traversal Example:
     *   Let's consider the following binary tree:
     *          1
     *         / \
     *        2   3
     *       / \ / \
     *       4 5 6 7
     *
     *       The postorder traversal of the above binary tree is: 4 5 2 6 7 3 1
     *
     *       Time Complexity: O(n)
     *       Space Complexity: O(h), where h is the height of the binary tree.
     *
     *
     * Non-Recursive (Iterative) Postorder Traversal:
     * In postorder traversal, each node is visited twice. That means, after processing the left subtree we will visit the current node and after processing the right subtree we will visit the same current node.
     * We would be processing the current node during the second visit. Here the Problem is how to differentiate whether we are returning from the left subtree or right subtree.
     *
     * We use a previous variable to keep track of the earlier traversed node. Let's assume current is the current node that is on top of the stack.
     * When previous is current's parent, we are traversing down the tree. In this case, if the left child is not null, we move to the left child.
     * If the left side is null, we look on the right side and if it is also null, we print the current node and pop it.
     *
     * If previous is current's left child, we are traversing up the tree from the left. We look at current's right child.
     * If it is not null, then move to the right child and repeat the process. Otherwise print current node and pop it.
     * If previous is current's right child, we are traversing up the tree from the right. In this case, we print the current node and pop it.
     *
     * Algorithm:
     * 1. Create a stack to store the nodes.
     * 2. Push the root node to the stack.
     * 3. While the stack is not empty, do the following:
     *  - Pop the top node from the stack.
     *  - If the right child of the popped node is not null, push it to the stack.
     *  - If the left child of the popped node is not null, push it to the stack.
     *  - Continue the process until the stack is empty.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(h), where h is the height of the binary tree.
     *
     *
     *
     *
     * Level Order Traversal:
     *
     * Level Order Traversal is also known as Breadth-First Traversal. It is described as follows:
     *   - Visit the root nodde.
     *   - While traversing level i, keep all the elements at level i+1 in the queue.
     *   - Move to the next level and visit all the nodes at that level.
     *   - Repeat this process until all levels are completed.
     *
     * Level Order Traversal Example:
     * Let's consider the following binary tree:
     *           1
     *          / \
     *         2   3
     *        / \ / \
     *        4 5 6 7
     *
     * The level order traversal of the above binary tree is: 1 2 3 4 5 6 7
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) Since, in the worst case, all the nodes on the entire last level could be in the queue simultaneously.
     */


    // Preorder Traversal

    public void preOrder(BinaryTreeNode root) {
        if (root != null) {
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // Iterative Preorder Traversal

    public ArrayList<Integer> preOrderIterative(BinaryTreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        s.push(root);
        while (!s.isEmpty()) {
            BinaryTreeNode temp = s.pop();
            res.add(temp.data);
            if (temp.right != null) {
                s.push(temp.right);
            }
            if (temp.left != null) {
                s.push(temp.left);
            }
        }
        return res;
    }

    // Inorder Traversal
    public void inOrder(BinaryTreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

    // Non-Recursive Inorder Traversal
    public ArrayList<Integer> inOrderIterative(BinaryTreeNode root) {
        ArrayList<Integer>res = new ArrayList<Integer>();
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        BinaryTreeNode currentNode = root;
        boolean done = false;
        while (!done) {
            if (currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.left;
            } else {
                if (s.isEmpty()) {
                    done = true;
                } else {
                    currentNode = s.pop();
                    res.add(currentNode.data);
                    currentNode = currentNode.right;
                }
            }
        }
        return res;
    }

    // Postorder Traversal
    public void postOrder(BinaryTreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }

    // Non-Recursive Postorder Traversal
    public ArrayList<Integer> postOrderIterative(BinaryTreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(root);
        BinaryTreeNode prev = null;
        while (!stack.isEmpty()) {
            BinaryTreeNode curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                res.add(curr.data);
                stack.pop();
            }
            prev = curr;
        }
        return res;
    }

    // Level Order Traversal
    public ArrayList<ArrayList<Integer>> levelOrder(BinaryTreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return res;
        }
        // Initialisation
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        q.offer(null);
        ArrayList<Integer> curr = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            BinaryTreeNode tmp = q.poll();
            if (tmp != null) {
                curr.add(tmp.data);
                if (tmp.left != null) {
                    q.offer(tmp.left);
                }
                if (tmp.right != null) {
                    q.offer(tmp.right);
                }
            } else {
                ArrayList<Integer> c_curr = new ArrayList<Integer>(curr);
                res.add(c_curr);
                curr.clear();
                if (!q.isEmpty()) {
                    q.offer(null);
                }
            }
        }
        return res;
    }
}
