class AVLTree {
    class Node {
        int key, height;
        Node left, right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }

    private Node root;
    int height(Node N) {
        return (N == null) ? 0 : N.height;
    }
    int getBalance(Node N) {
        return (N == null) ? 0 : height(N.left) - height(N.right);
    }
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }
    Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;
        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    public void insert(int key) {
        root = insert(root, key);
    }
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    // Pre-order traversal: Root → Left → Right
public void preOrder() {
    preOrder(root);
    System.out.println();
}

private void preOrder(Node node) {
    if (node != null) {
        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}

// Post-order traversal: Left → Right → Root
public void postOrder() {
    postOrder(root);
    System.out.println();
}

private void postOrder(Node node) {
    if (node != null) {
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.key + " ");
    }
}

    // Main method 
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int[] keys = {10, 20, 30, 40, 50, 25};

        for (int key : keys)
            tree.insert(key);

        System.out.print("In-order traversal of AVL Tree: ");
        tree.inOrder();
        System.out.println("Pre-order traversal of AVL Tree: ");
        tree.preOrder();
        System.out.println("Post-order traversal of AVL Tree: ");
        tree.postOrder();
    }
}