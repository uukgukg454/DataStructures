package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfTree {

    public static void main(String [] args) {
        TreeNode root = createTree();
        rightView(root);
    }

    public static void rightView(TreeNode root) {
        if(root==null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int rightEle=-1;
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            if(node !=null) {
                rightEle =node.data;
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            } else {
                if(!q.isEmpty())
                    q.add(null);
                System.out.print(rightEle+" ");

            }
        }

    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left= new TreeNode(8);
        return root;
    }
}
