public class levelOrderTraversal {
    int height(Node root)
    {
        if(root==null) return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }
    int countNodes(Node root)
    {
        if(root==null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    void levelOrderRec(Node root, int level, int[][] res, int[] indices)
    {
        if(root ==null) return;
        res[level][indices[level]++]=root.key;

        levelOrderRec(root.left, level+1, res, indices);
        levelOrderRec(root.right, level+1, res, indices);
        return;
    }
    int[][] levelOrder(Node root)
    {
        int h = height(root);
        int count = countNodes(root);
        int[][] res = new int[h][count];
        int[] indices = new int[h];
        levelOrderRec(root,0,res,indices);

        int[][] trimmed = new int[h][];
        for (int i = 0; i < h; i++) {
            trimmed[i]= new int[indices[i]];
            System.arraycopy(res[i], 0, trimmed[i], 0, indices[i]);            
        }
        return trimmed;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(12);
        root.right = new Node(13);

        root.left.left = new Node(7);
        root.left.right = new Node(14);

        root.right.right = new Node(2);

        root.left.left.left = new Node(17);
        root.left.left.right = new Node(23);

        root.left.right.left = new Node(27);
        root.left.right.right = new Node(3);

        root.right.right.left = new Node(8);
        root.right.right.right = new Node(11);

        levelOrderTraversal tree = new levelOrderTraversal();
        int[][] res = tree.levelOrder(root);

        for (int i = 0; i < res.length; i++) {
            System.out.print("[");
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]);
                if(j<res[i].length-1) System.out.print(" , ");                               
            }
            System.out.print("]");
        }
    }
}
class Node{
    int key;
    Node left, right;
    Node(int data)
    {
        key = data;
        left=right=null;
    }
}