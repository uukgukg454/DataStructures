package datastructure.tree;

import java.util.Map;
import java.util.TreeMap;

public class TopViewOfTree {

    public static void main(String [] args) {
        TreeNode root = createTree();
        int level =0;
        TreeMap<Integer, TreeNode> tm = new TreeMap<>();
        topView(root, level, tm);
        for(Map.Entry<Integer,TreeNode> e: tm.entrySet()) {
            System.out.print(e.getValue().data +" ");
        }
    }

    public static void topView(TreeNode root, int level, TreeMap<Integer,TreeNode> tm) {
        if(root ==null)
            return;
        tm.putIfAbsent(level, root);
        topView(root.left, level-1, tm);
        topView(root.right, level+1, tm);
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
