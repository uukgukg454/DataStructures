package datastructure.tree;

import java.util.ArrayList;
import java.util.List;

public class AllRootToLeafPath {

    public static void main(String [] args) {
        TreeNode root = createTree();
        System.out.println("paths :"+ binaryTreePaths(root));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        pathsUtil(root,list,"");
        return list;
    }

    public static void pathsUtil(TreeNode root, List<String> list, String str) {
        if(root==null)
            return;
        if(str.equals(""))
            str=str+root.data;
        else
            str= str+"->"+root.data;
        if(root.left==null && root.right==null) {
            list.add(str);
        } else {
            pathsUtil(root.left, list, str);
            pathsUtil(root.right, list, str);
        }
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
