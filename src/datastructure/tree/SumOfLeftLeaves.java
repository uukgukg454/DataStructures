package datastructure.tree;

public class SumOfLeftLeaves {

    public static void main(String [] args) {
        TreeNode root = createTree();
        System.out.println("sum :"+ sumOfLeftLeaves(root));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        int currSum=0;
        if(root==null)
            return 0;
        if(root.left!=null && root.left.left==null && root.left.right==null) {
            currSum = root.left.data;
        }
        return currSum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
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
