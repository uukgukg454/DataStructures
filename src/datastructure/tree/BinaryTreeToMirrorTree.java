package datastructure.tree;

public class BinaryTreeToMirrorTree {

    public static void main(String [] args) {
        TreeNode root = createTree();
        printTree(root);
        System.out.println();
        convert(root);
        printTree(root);
    }

    static void convert(TreeNode root) {
        if(root==null)
            return;
        TreeNode temp = root.left;
        root.left =root.right;
        root.right =temp;
        convert(root.left);
        convert(root.right);
    }

    static void printTree(TreeNode root) {
        if(root==null)
            return;
        printTree(root.left);
        System.out.print(root.data+" ");
        printTree(root.right);
    }


    public static TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        return root;
    }
}
