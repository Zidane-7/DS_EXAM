class binarySearchTree {
    public static void main(String[] args) {
        binarySearchTreeTest tree = new binarySearchTreeTest();
        tree.insert(5);
        tree.insert(24);
        tree.insert(73);
        tree.insert(82);
        tree.insert(2);
        tree.inorder();
        tree.delete(24);
        tree.inorder();
        int key1 = 5; int key2 = 24;
        if(tree.search(key1))
        System.out.println(key1+" is found in the Binary Search Tree");
        else 
        System.out.println(key1+" is not found in Binary Search Tree");
        if(tree.search(key2))
        System.out.println(key2+" is found in the Binary Search Tree");
        else 
        System.out.println(key2+" is not found in Binary Search Tree");
        System.out.println("Traversals: ");
        tree.inorder();
        tree.preorder();
        tree.postorder();        
    }    
}
class binarySearchTreeTest{
    Node root;
    binarySearchTreeTest()
    {
        root = null;
    }
    void insert(int data)
    {
        root=insertRec(root, data);
    }
    Node insertRec(Node root, int data)
    {
        if(root==null)
        {
            root = new Node(data);
            return root;
        }
        if(data<root.key)
        {
            root.left=insertRec(root.left, data);
        }
        else if(data>root.key)
        {
            root.right=insertRec(root.right, data);            
        }
        return root;
    }
    boolean search(int data)
    {
        return searchRec(root, data);
    }
    boolean searchRec(Node root, int data)
    {
        if(root==null)
        return false;
        if(root.key==data)
        return true;
        if(data<root.key)
        return searchRec(root.left, data);
        return searchRec(root.right, data);
    }
    void delete(int data)
    {
        root = deleteRec(root, data);
    }
    Node deleteRec(Node root, int data)
    {
        if(root==null)
        {
            return root;
        }
        if(data<root.key)
        {
            root.left=deleteRec(root.left, data);           
        }
        else if(data>root.key)
        {
            root.right=deleteRec(root.right, data);
        }
        else 
        {
            if(root.left==null)
            return root.right;
            else if(root.right==null)
            return root.left;
            root.key=minValue(root.right);
            root.right=deleteRec(root.right, root.key);
        }
        return root;
    }
    int minValue(Node root)
    {
        int minv=root.key;
        while (root.left!=null) {
            minv=root.left.key;
            root=root.left;            
        }
        return minv;
    }
    void inorder()
    {
        System.out.print("Inorder Traversal: ");
        inorderRec(root);
        System.out.println();
    }
    void inorderRec(Node root)
    {
        if(root!=null)
        {
            inorderRec(root.left);
            System.out.print(root.key+" ");
            inorderRec(root.right);
        }
    }
    void preorder()
    {
        System.out.print("Preorder Traversal: ");
        preorderRec(root);
        System.out.println();
    }
    void preorderRec(Node root)
    {
        if(root!=null)
        {
            System.out.print(root.key+" ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }
    void postorder()
    {
        System.out.print("Postorder Traversal: ");
        postorderRec(root);
        System.out.println();      
    }
    void postorderRec(Node root)
    {
        if(root!=null)
        {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key+" ");
        }
    }

}
class Node{
    int key;
    Node left, right;
    Node(int data)
    {
        key=data;
        left=right=null;
    }
}