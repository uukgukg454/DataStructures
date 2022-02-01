package datastructure.tree;

public class NoOfLeafNodes {
    public static void main(String [] args) {
        TreeNode root = createTree();
        System.out.println("No of lead nodes in tree:"+ count(root));
    }

    private static int count(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        return count(root.left)+count(root.right);
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
