package datastructure.tree;

public class SymmetricTree {

    public static void main(String [] args) {
        TreeNode root = createTree();
        boolean result= false;
        if(root==null) {
            result = true;
        } else {
            result = isSymmetric(root.left, root.right);
        }
        System.out.println(result);
    }

    /**
     *Given a Binary Tree.
     * Check whether it is Symmetric or not, i.e. whether the binary tree is a Mirror image of itself or not.
     */
    static boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)
            return true;
        if(root1!=null && root2!=null) {
            return (root1.data==root2.data) &&
                    isSymmetric(root1.left, root2.right) &&
                    isSymmetric(root1.right, root2.left);
        }
        return false;
    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(5);
        root.left= new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.right.right = new TreeNode(2);
        return root;
    }
}
