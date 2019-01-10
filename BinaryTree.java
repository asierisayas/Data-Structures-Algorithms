/*
10.1 Test if a binary tree is height-balanced
Write a program that takes as input the root of a binary tree
and checks whether it is heigh-balanced
*/
public boolean isBalanced(Node root) {
    if (root == null) {
        return true;
    }

    if (Math.abs(getHeight(root.left), getHeight(root.right)) < 2) {
        return isBalanced(root.left) && isBalanced(root.right);
    }

    return false;
}

public int getHeight(Node root) {
    if (root == null) {
        return -1;
    }

    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
}

/*
10.2 Test if a Binary Tree is Symmetric
*/
public boolean isSymmetric(Node root1, Node root2) {
    if (root1 == null && root2 == null) {
        return true;
    }

    if (root1 == null || root2 == null) {
        return false;
    }

    if (root1.val == root2.val) {
        return isSymmetric(root1.right, root2.left) && isSymmetric(root1.left, root2.right);
    }

    return false;
}

/*
10.3 Compute the LCA in a Binary Tree
Design an algorithm for computing the LCA of two nodes in a binary
tree in which nodes do not have a parent field
*/
public Node LCA(Node root, Node node1, Node node2) {
    if (root.val > node1.val && root.val < node2.val) {
        return root;
    }

    if (root.val < node1.val && root.val < node2.val) {
        return LCA(root.right, node1, node2);
    }

    return LCA(root.left, node1, node2);
}

/*
10.5 Sum the root-to-leaf paths in a binary tree
Design an algorithm to compute the sum of the binary numbers
represented by the root-to-leaf paths
*/
public int sumPaths(Node root, int currSum) {
    if (root == null) {
        return 0;
    }

    if (root.left == null && root.right == null) {
        return currSum * 10 + root.val;
    }

    return sumPaths(root.left, currSum * 10 + root.val) && 
        sumPaths(root.right, currSUm * 10 + root.val);
}

/*
10.6 Find a root to leaf path with specified sum
Write a program which takes as input an integer and a binary tree with
integer node weights, and checks if there exists a leaf whose path
weight equals the given integer
*/

public boolean findPath(Node root, int currSum) {
    if (root == null) {
        return false;
    }

    if (root.left != null && root.right != null && currSum - root.val == 0) {
        return true;
    }

    return findPath(root.left, currSum - root.val) || 
        findPath(root.right, currSum - root.val);
}

/*
10.7 Implement an inorder traversal without recursion
*/
public List<Node> inOrder(Node root) {
    Node curr = root;
    List<Node> list = new ArrayList<>();
    Stack<Node> stack = new Stack<>();

    while (!stack.isEmpty() || curr != null) {
        if (curr != null) {
            stack.push(curr);
            curr = curr.left;
        } else {
            curr = stack.pop();
            list.add(curr);
            curr = curr.right;
        }
    }

    return list;
}

/*
10.8 Implement a preorder traversal without recursion
*/
public List<Node> preOrder(Node root) {
    List<Node> list = new ArrayList<>();
    Stack<Node> stack = new Stack<>();

    stack.push(root);
    while (!stack.isEmpty()) {
        Node popped = stack.pop();
        list.add(popped);

        if (popped.right != null) {
            stack.push(popped.right);
        }

        if (popped.left != null) {
            stack.push(popped.left);
        }
    }

    return list;
}

/*
10.10 Compute the inorder successor
*/
public Node successor(Node root, Node node) {
    Node curr = root;
    Node maybe = null;
    while (curr != null) {
        if(curr.val > node.val) {
            prev = curr;
            curr = curr.left;
        } else {
            curr = curr.right;
        }
    }

    return maybe;
}

/*
Reconstruct a binary tree from traversal data
Given an inorder traversal sequence and a preorder traversal
sequence of a binary tree write a program to reconstruct the tree. 
Assume ach node has a unique tree
*/