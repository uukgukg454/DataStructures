package datastructure.tree;

/**
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum
 */
public class PathSum {
    public static void main(String [] args) {
        TreeNode root = createTree();
        int targetSum =22;
        System.out.println("sum path exists:"+ hasPathSum(root,targetSum));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSumUtil(root, 0, targetSum);

    }

    public static boolean hasPathSumUtil(TreeNode root, int currSum, int targetSum) {
        if(root==null)
            return false;
        currSum += root.data;
        if(root.left==null && root.right==null) {
            return currSum == targetSum;
        }
        return hasPathSumUtil(root.left, currSum, targetSum) || hasPathSumUtil(root.right, currSum, targetSum);
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
