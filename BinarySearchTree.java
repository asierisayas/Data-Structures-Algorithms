/*
15.1 Test if a binary tree satisfies the BST Property
*/
public boolean isValid(Node root) {
    return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

public boolean isValid(Node root, int min, int max) {
    if (root == null) {
        return true;
    }

    if (root.data < min || root.data > max) {
        return false;
    }

    return isValid(root.left, min, root.val) && 
        isValid(root.right, root.val, max);
}

/*
15.2 Find the first key greater than a given value in a BST
O(h), where h is the height of the tree
*/
public int findFirstGreater(Node root, int k) {
    Node curr = root;
    Node soFar = null;

    while (curr != null) {
        if (curr.val > k) { //possible inorder successor
            soFar = curr;
            curr = curr.left;
        } else {
            curr = curr.right;
        }
    }

    return soFar.val;
}

/*
15.3 Find the K largest elements in a BST
Write a program that takes as input a BST and an integer K, and returns
the k largest elements in the BST in decreasing order
*/
public static List<Integer> findKLargestinBST(Node root, int k) {
    List<Integer> list = new ArrayList<>();
    findKLargestinBST(root, k, list);
    return list;
}

public static void findKLargestinBST(Node root, int k, List<Integer> list) {
    if (root != null && list.size() < k) {
        findKLargestinBST(root.right, k, list);
        if (list.size() < k) {
            list.add(root.val);
            findKLargestinBST(root.left, k, list);
        }
    }
}

/*
15.10 Insert into BST
*/
public Node insert(Node root, int val) {
    if (root == null) {
        return new Node(val);
    }

    if (root.val > val) {
        root.left = insert(root.left, val);
    } else if (root.val < val) {
        root.right = insert(root.right, val);
    }

    return root;
}

/*
15.10 Remove from BST
*/
public Node delete(Node root, int val) {
    if (root == null) {
        return null;
    }

    if (root.val < val) {
        root.right = delete(root.right, val);
    } else if (root.val > val) {
        root.left = delete(root.left, val);
    } else {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        Node successor = successor(root.right);
        root.val = successor.val;
        root.right = delete(root.right, root.val);       
    }

    return root;
}

public Node successor(Node root) {
    while(root.left != null) {
        root = root.left;
    }
    return root;
}