package datastructure.tree;

import java.util.ArrayList;

public class BoundaryTraversal {

    public static void main(String [] args) {
        TreeNode root = createTree();
        System.out.print("boundary traversal:"+boundary(root));
    }

    static ArrayList <Integer> boundary(TreeNode node)
    {
        ArrayList<Integer> list = new ArrayList<>();
        boundaryUtil(node, list);
        return list;
    }

    static void boundaryUtil(TreeNode root, ArrayList<Integer> list) {
        if(root==null)
            return;
            /*without this check for a single node tree, we will print root value 2 times.
            duplicate will be introdcued by leafNodes method.
            */
        if(root.left==null && root.right==null) {
            list.add(root.data);
            return;
        }
        list.add(root.data);
        leftBoundary(root.left,list);
        leafNodes(root, list);
        rightBoundary(root.right,list);
    }

    static void leftBoundary(TreeNode root,ArrayList<Integer> list) {
        if(root==null)
            return;
        if(root.left!=null) {
            list.add(root.data);
            leftBoundary(root.left, list);
        }
        else if(root.right!=null) {
            list.add(root.data);
            leftBoundary(root.right, list);
        }
    }

    static void rightBoundary(TreeNode root,ArrayList<Integer> list) {
        if(root==null)
            return;
        if(root.right!=null) {
            rightBoundary(root.right, list);
            list.add(root.data);
        }
        else if (root.left!=null) {
            rightBoundary(root.left,list);
            list.add(root.data);
        }
    }

    static void leafNodes(TreeNode root,ArrayList<Integer> list) {
        if(root==null)
            return;
        leafNodes(root.left, list);
        if(root.left==null && root.right==null) {
            list.add(root.data);
        }
        leafNodes(root.right, list);
    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(20);
        root.left= new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);

        return root;
    }
}
