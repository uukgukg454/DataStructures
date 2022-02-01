package datastructure.tree;

public class SizeOfTree {
    
    public static void main(String [] args) {
        TreeNode root = createTree();
        System.out.println("No of lead nodes in tree:"+ size(root));
    }

    private static int size(TreeNode root) {
        if(root==null)
            return 0;
        return size(root.left)+size(root.right)+1;
    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left= new TreeNode(8);

        return root;
    }

}
