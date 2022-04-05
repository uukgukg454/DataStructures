package datastructure.tree;

/**
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 *     For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 *
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A leaf node is a node with no children.
 */
public class SumRootToLeafNumbers {

    public static void main(String [] args) {
        TreeNode root = createTree();
        System.out.println("sum :"+ sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        return sumNumbersUtil(root, 0);
    }

    public static int sumNumbersUtil(TreeNode root, int sum) {
        if(root==null)
            return 0;
        sum =sum*10+root.data;
        if(root.left==null && root.right==null)
            return sum;
        return sumNumbersUtil(root.left, sum) + sumNumbersUtil(root.right, sum);
    }
    public static TreeNode createTree() {
        TreeNode root = new TreeNode(5);
        root.left= new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        return root;
    }
}
