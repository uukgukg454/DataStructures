package datastructure.tree;

public class SumTree {

    public static void main(String [] args) {
        TreeNode root = createTree();
        System.out.println(isSumTree(root));
    }

    static boolean isSumTree(TreeNode root) {
        if(root==null)
            return true;
       if(root.left==null && root.right==null)
           return true;
       int left = sum(root.left);
       int right = sum(root.right);
       return (left+right==root.data) && isSumTree(root.left) && isSumTree(root.right);
    }

    static int sum(TreeNode root) {
        if(root==null)
            return 0;
        return sum(root.left)+sum(root.right)+root.data;
    }



    public static TreeNode createTree() {
        TreeNode root = new TreeNode(26);
        root.left= new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(3);
        return root;
    }
}
