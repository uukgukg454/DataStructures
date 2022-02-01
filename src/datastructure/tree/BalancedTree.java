package datastructure.tree;

public class BalancedTree {

    public static void main(String [] args) {
        TreeNode root = createTree();
        System.out.println(isBalanced(root));
        System.out.println(isBalancedEfficientWay(root, new Height()));

    }

    /**
     *Given a binary tree, find if it is height balanced or not.
     A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree.
     * Solution takes 0(n^2) as we are calculating height in separate recursion
     */
    static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return (Math.abs(calculateHeight(root.left) - calculateHeight(root.right)) <= 1)
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    static int calculateHeight(TreeNode root) {
        if(root==null)
            return 0;
        int left = calculateHeight(root.left);
        int right = calculateHeight(root.right);
        if(left>right)
            return left+1;
        else
            return right+1;
    }

    //calculating height in same recursion
    static boolean isBalancedEfficientWay(TreeNode root ,Height height) {
        if (root == null) {
            height.h = 0;
            return true;
        }
        Height leftHeight= new Height();
        Height rightHeight = new Height();

        boolean lResult = isBalancedEfficientWay(root.left, leftHeight);
        boolean rResult = isBalancedEfficientWay(root.right, rightHeight);

        int lh = leftHeight.h;
        int rh = rightHeight.h;

        height.h = Math.max(lh,rh)+1;

        return Math.abs(lh-rh)<=1 && lResult && rResult;
    }

    static class Height {
        int h =0;
    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        //root.left.left.left = new TreeNode(4); //(when uncommented result will be false)

        return root;
    }
}
