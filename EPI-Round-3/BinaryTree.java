/*
10.1 Test if a binary tree is height-balanced
Write a program that takes as input the root of a binary tree and checks
whether the tree is height-balanced
*/
public boolean isBalanced(Node root) {
    if (root == null) {
        return true;
    }

    if (Math.abs(getHeight(root.left) - getHeight(root.right) <= 1)) {
        return isBalanced(root.left) && isBalanced(root.right);
    }

    return false;
}

public int getHeight(Node root) {
    if (root == null) {
        return 0;
    }

    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
}

/*
10.2 Test if a binary tree is symmetric
Write a program that checks whether a binary tree is symmetric
*/
public boolean isSymmetric(Node root) {

}

public boolean symmetryHelper(Node first, Node second) {
    if (first == null && second == null) {
        return true;
    } else if (first == null || second == null) {
        return false;
    } else if (first.val == second.val) {
        return symmetryHelper(first.left, second.right) && symmetryHelper(first.right, second.left);
    }

    return false;
}

/*
10.5 Sum the root-to-leaf paths in a binary tree
*/
public int sumPaths(Node root) {
    return helper(root, 0);
}

public int helper(Node root, int currSum) {
    if (root == null) {
        return 0;
    } else if (root.left == null && root.right == null) {
        return (currSum * 10) + root.val;
    } else {
        return helper(root.left, currSum * 10 + root.val) + helper(root.right, currSum * 10 + root.val);
    }
}

/*
10.6 Find a root to leaf path with specified sum
Write a program which takes as input an integer and a binary tree
with integer node weight, and checks if there exists a leaf whose path
weight equals the given integer
*/
public boolean findPath(Node root, int sum) {
    if (root == null) {
        return false;
    }

    if (root.left == null && root.right == null && sum - root.val == 0) {
        return true;
    }

    return findPath(root.left, sum - root.val) || findPath(root.right, sum - root.val);
}

/*
10.7 Implement an inorder traversal without recursion
Write a program which takes as input a binary tree and performs
and inorder traversal of the tree
*/
public List<Integer> inOrder(Node root) {
    List<Integer> out = new ArrayList<>();
    Stack<Node> stack = new Stack<>();

    Node curr = root;

    while (curr != null || !stack.isEmpty()) {
        if (curr != null) {
            stack.push(curr);
            curr = curr.left;
        } else {
            Node curr = stack.pop();
            out.add(curr.val);
            curr = curr.right;
        }
    }

    return out;
}

/*
10.8 Implement a preorder traversal without recursion
Write a program which takes as input a binary tree and performs
a preorder traversal of the tree
*/
public List<Integer> preOrder(Node root) {
    List<Integer> out = new ArrayList<>();
    Stack<Node> stack = new Stack<>();

    Node curr = root;
    stack.push(curr);

    while (!stack.isEmpty()) {
        curr = stack.pop();
        out.add(curr.val);

        if (curr.right != null) {
            stack.push(curr.right);
        }

        if (curr.left != null) {
            stack.push(curr.right);
        }
    }

    return out;
}

/*
10.10 Compute the successor
Design an algorithm that computes the successor of a node in a binary
tree. Assume that each node stores its parent
*/
public Node successor(Node root, Node node) {
    Node res = null;

    while (root != null) {
        if (root.val > node.val) {
            res = root;
            root = root.left;
        } else {
            root = root.right;
        }
    }
}