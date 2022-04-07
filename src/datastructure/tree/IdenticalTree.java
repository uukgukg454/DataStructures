package datastructure.tree;

public class IdenticalTree {

    public static void main(String [] args) {
        TreeNode root1 = createTree1();
        TreeNode root2 = createTree2();
        System.out.println(isIdentical(root1, root2));

    }

    static boolean isIdentical(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        return (root1.data==root2.data)
                && isIdentical(root1.left, root2.left)
                && isIdentical(root1.right, root2.right);
    }

    public static TreeNode createTree1() {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        return root;
    }

    public static TreeNode createTree2() {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        return root;
    }
}

