package datastructure.tree;

public class DiameterOfTree {

    public static void main(String [] args) {
        TreeNode root = createTree();
        System.out.println(diameter(root, new Height()));

        A a = new A();
        diameterAnotherWay(root, a);
        System.out.println(a.ans);
    }

    static class Height {
        int h = 0;
    }

    static class A
    {
        int ans = Integer.MIN_VALUE;
    }

    static int diameter(TreeNode root, Height height) {
        if(root==null) {
            height.h = 0;
            return 0;
        }

        Height leftHeight =  new Height();
        Height rightHeight = new Height();

        int ld = diameter(root.left,leftHeight);
        int rd = diameter(root.right,rightHeight);

        int lh = leftHeight.h;
        int rh = rightHeight.h;

        height.h = Math.max(lh,rh)+1;

        return Math.max(lh+rh+1, Math.max(ld,rd));
    }

    static int diameterAnotherWay(TreeNode root, A a)
    {
        if (root == null)
            return 0;

        int left_height = diameterAnotherWay(root.left, a);

        int right_height = diameterAnotherWay(root.right, a);

        // update the answer, because diameter of a
        // tree is nothing but maximum value of
        // (left_height + right_height + 1) for each node
        a.ans = Math.max(a.ans, 1 + left_height +
                right_height);

        return 1 + Math.max(left_height, right_height);
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
