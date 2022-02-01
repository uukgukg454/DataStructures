package datastructure.tree;

import java.util.Map;
import java.util.TreeMap;

public class BottomViewOfTree {

    public static void main(String [] args) {
        TreeNode root = createTree1();
        int level =0;
        int currHeight= 0;
        TreeMap<Integer, int[]> tm = new TreeMap<>();

        bottomView(root, level, currHeight, tm);
        for(Map.Entry<Integer,int[]> e: tm.entrySet()) {
            System.out.print(e.getValue()[0] +" ");
        }
    }

    public static void bottomView(TreeNode root, int level, int currHeight, TreeMap<Integer,int []> tm) {
        if(root ==null)
            return;
        if(!tm.containsKey(level)) {
            tm.put(level, new int[]{root.data,currHeight});
        } else {
            int [] arr = tm.get(level);
            if(arr[1]<=currHeight) {
                arr[0] =root.data;
                arr[1]= currHeight;
                tm.put(level, arr);
            }
        }
        bottomView(root.left, level-1, currHeight+1, tm);
        bottomView(root.right, level+1,currHeight+1, tm);
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

    public static TreeNode createTree1() {
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
