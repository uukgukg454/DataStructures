package datastructure.tree;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TopViewOfTree {

    public static void main(String [] args) {
        TreeNode root = createTree();
        TreeMap<Integer, Pair> tm = new TreeMap<>();
        topView(root, 0, 0, tm);
        for(Map.Entry<Integer,Pair> e: tm.entrySet()) {
            System.out.print(e.getValue().data +" ");
        }
    }

    public static void topView(TreeNode root, int level, int depth,  TreeMap<Integer,Pair> tm) {
        if(root ==null)
            return;
        if(!tm.containsKey(level)) {
            tm.put(level,new Pair(root.data, depth));
        } else {
            Pair existingPair = tm.get(level);
            if(existingPair.depth>depth) {
                tm.put(level, new Pair(root.data, depth));
            }
        }
        topView(root.left, level-1, depth+1, tm);
        topView(root.right, level+1, depth+1, tm);
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

    static class Pair {
        int depth;
        int data;

        Pair(int data, int depth) {
            this.data= data;
            this.depth = depth;
        }
    }
}
