/*
10.1 Test if a binary tree is height-balanced
Write a program that takes as input the root of a binary tree and 
checks whether the tree is height balanced
*/
public boolean isBalanced(TreeNode root) {
    if (root == null) {
        return true;
    }

    int diff = Math.abs(getHeight(root.left) - getHeight(root.right));
    if (diff <= 1) {
        return isBalanced(root.left) && isBalanced(root.right);
    }

    return false;
}

public int getHeight(TreeNode root) {
    if (root == null) {
        return -1;
    }
    
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
}

/*
10.2 Test if a binary tree is symmetric
Write a program that checks whether a binary tree is symmetric
*/
public boolean isSymmetric(TreeNode root) {
    return isSymmetric(root, root);
}

public boolean isSymmetric(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
        return true;
    }

    if (root1 != null && root2 != null && root1.val == root2.val) {
        return isSymmetric(root1.left, root2.right) && 
            isSymmetric(root1.right, root2.left);
    }

    return false;
}

/*
10.5 Sum the root to leaf paths in a binary tree
Design an algorithm to compute the sume of the numbers represented by
the root to leaf paths
*/
public int sumPaths(TreeNode root) {
    return sumPaths(root, 0);
}

public int sumPaths(TreeNode root, int currSum) {
    if (root == null) {
        return 0;
    }

    if (root.left == null and root.right == null) {
        return currSum * 10 + root.val;
    }

    return sumPaths(root.left, root.val*10 + currSum) +
        sumPaths(root.right, root.val*10 + currSum);
}

/*
10.6 Find a root to leaf path with specified sum
Write a program which takes as input an integer and a binary tree
with integer node weights, and checks if there exists a leaf whose 
path weight equals the given integer. 
*/
public boolean pathSum(TreeNode root, int currSum) {
    if (root == null) {
        return false;
    }

    if (root.left == null && root.right == null && currSum - root.val == 0) {
        return true;
    }
    int newSum = currSum - root.val;
    return pathSum(root.left, newSum) || pathSum(root.right, newSum);
}

/*
10.7 Implement an inorder traversal without recrusion
*/
public List<Integer> inorder(TreeNode root) {
    List<Integer> output = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>(); 
    TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
        if (curr != null) {
            stack.push(curr);
            curr = curr.left;
        } else {
            curr = stack.pop();
            output.add(curr.val);
            curr = curr.right;
        }
    }

    return output;
}

/*
10.8 Implement a preorder traversal without recursion
*/
public List<Integer> preorder(TreeNode root) {
    List<Integer> output = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>(); 
    TreeNode curr = root;

    stack.push(curr);
    while (!stack.isEmpty()) {
        curr = stack.pop();
        output.add(curr);
        if (curr.right != null) {
            stack.push(curr.right);
        }
        if (curr.left != null) {
            stack.push(curr.left);
        }
    }

    return output;
}
