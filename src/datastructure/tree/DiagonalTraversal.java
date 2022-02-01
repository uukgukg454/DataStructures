package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;


public class DiagonalTraversal {
    public static void main(String [] args) {
        TreeNode root = createTree();
        diagonal(root);

    }

    public static void diagonal(TreeNode root) {
        if(root==null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        while(root!=null) {
            q.add(root);
            root=root.right;
        }
        q.add(null);
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            if(node!=null) {
                System.out.print(node.data+" ");
                if(node.left!=null) {
                    q.add(node.left);
                    TreeNode rightNode = node.left.right;
                    while(rightNode!=null) {
                        q.add(rightNode);
                        rightNode = rightNode.right;
                    }
                }
            }else if(!q.isEmpty()) {
                    q.add(null);
                    System.out.println();
            }
        }


    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(8);
        root.left= new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        root.right.left.left = new TreeNode(4);

        return root;
    }
}
