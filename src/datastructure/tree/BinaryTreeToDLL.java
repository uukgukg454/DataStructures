package datastructure.tree;

public class BinaryTreeToDLL {

    public static void main(String [] args) {
        TreeNode root = createTree();
       printDLL(bToDLL(root));
    }

    static TreeNode bToDLL(TreeNode root)
    {
        DLLNode node = new DLLNode(null, null);
        bToDLLUtil(root,node);
        return node.head;
    }

    static void bToDLLUtil(TreeNode root, DLLNode node) {
        if (root == null)
            return;
        bToDLLUtil(root.left,node);
        if (node.prev == null)
            node.head = root;
        else {
            root.left = node.prev;
            node.prev.right = root;
        }
        node.prev = root;
        bToDLLUtil(root.right, node);
    }

    static void printDLL(TreeNode head) {
       while(head!=null) {
           System.out.print(head.data+" ");
           head= head.right;
       }
    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(5);
        root.left= new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        return root;
    }
}

class DLLNode {
    TreeNode head;
    TreeNode prev;

    public DLLNode(TreeNode head, TreeNode prev) {
        this.head= head;
        this.prev= prev;
    }
}
