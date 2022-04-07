package datastructure.tree;

public class LowestCommonAncestor {
    public static void main(String [] args) {
        TreeNode root = createTree();
        System.out.println("lca:"+ lowestCommonAncestor(root, root.left.left, root.right.left).data);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        if(root==p || root==q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p,q);
        TreeNode right = lowestCommonAncestor(root.right, p,q);
        if(left !=null && right!=null)
            return root;
        else
            return left!=null?left:right;

    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.left.left = new TreeNode(11);
        root.right.left.left.left = new TreeNode(12);
        return root;
    }
}
