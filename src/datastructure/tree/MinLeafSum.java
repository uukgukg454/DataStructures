package datastructure.tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class MinLeafSum {
    public static void main(String [] args) {
        TreeNode root = createTree();
        System.out.println("sum :"+ minLeafSum(root));
    }

    public static int minLeafSum(TreeNode root){
        int result= 0;
        Map<Integer, ArrayList<Integer>> hm = new TreeMap<>();
        minLeafSumUtil(root, 0, hm);
        for(Map.Entry<Integer, ArrayList<Integer>> e: hm.entrySet()) {
            ArrayList<Integer> list = e.getValue();
            for(int i=0;i<list.size();i++) {
                result = result+list.get(i);
            }
            break;
        }
        return result;
    }

    public static void minLeafSumUtil(TreeNode root, int level, Map<Integer, ArrayList<Integer>> hm) {
        if(root==null)
            return;
        if(root.left==null && root.right==null) {
            if(!hm.containsKey(level) ) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(root.data);
                hm.put(level, list);
            } else {
                ArrayList<Integer> list = hm.get(level);
                list.add(root.data);
                hm.put(level, list);
            }
        }
        minLeafSumUtil(root.left, level+1, hm);
        minLeafSumUtil(root.right, level+1, hm);
    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(5);
        root.left= new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        return root;
    }
}
