package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightTree {

    public static void main(String [] args) {
        TreeNode root = createTree();
        System.out.println("height of tree using queue:"+ heightUsingQueue(root));
        System.out.println("height of tree using recursion:"+ heightByRecursion(root));
    }

    public static int heightUsingQueue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int height = 0;
        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
            TreeNode node= q.remove();
            if(node !=null) {
                if(node.left!=null) {
                    q.add(node.left);
                }
                if(node.right!=null) {
                    q.add(node.right);
                }
            } else {
                if(!q.isEmpty()) {
                    q.add(null);
                }
                height++;
            }
        }
        return height;
    }

    public static int heightByRecursion(TreeNode root) {
        if(root==null)
            return 0;
        int leftHeight = heightByRecursion(root.left);
        int rightHeight = heightByRecursion(root.right);
        if(leftHeight>rightHeight) {
            return leftHeight+1;
        } else {
            return rightHeight+1;
        }
    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(4);
        root.left= new TreeNode(5);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(1);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        return root;
    }
}
