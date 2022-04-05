package datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree and an integer targetSum,
 * return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
 * Each path should be returned as a list of the node values, not node references.
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 */
public class AllPathSumFromRootToLeaf {
    public static void main(String [] args) {
        TreeNode root = createTree();
        int targetSum = 27;
        System.out.println("paths :"+ pathSum(root, targetSum));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> entry = new ArrayList<>();
        pathSumUtil(root, targetSum, 0, list, entry);
        return list;
    }

    public static void pathSumUtil(TreeNode root, int targetSum, int sum, List<List<Integer>> list, List<Integer> entry) {
        if(root==null)
            return;
        entry.add(root.data);
        sum=sum+root.data;
        if(sum==targetSum && root.left==null && root.right==null) {
            ArrayList<Integer> entry1 = new ArrayList<>(entry);
            list.add(entry1);
        }
        else {
            pathSumUtil(root.left, targetSum, sum, list, entry);
            pathSumUtil(root.right, targetSum, sum, list, entry);
        }
        entry.remove(entry.size()-1);
    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(5);
        root.left= new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        return root;
    }
}
