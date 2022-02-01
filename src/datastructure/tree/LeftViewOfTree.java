package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfTree {

    public static void main(String [] args) {
        TreeNode root = createTree();
        leftView(root);
    }

    public static void leftView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean leftFlag = true;
        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            if(node !=null) {
                if(node.left !=null)
                    q.add(node.left);
                if(node.right !=null)
                    q.add(node.right);
                if(leftFlag)
                    System.out.println(node.data+" ");
                leftFlag =false;
            } else {
                if(!q.isEmpty()) {
                    q.add(null);
                }
                leftFlag=true;

            }
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
