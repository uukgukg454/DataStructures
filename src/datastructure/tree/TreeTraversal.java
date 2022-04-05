package datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {

    public static void main(String [] args) {
        TreeNode root = createTree();
        System.out.println("preorder using recursion:");
        preOrderRecursion(root);
        System.out.println("\npreorder using stack:");
        preOrderUsingStack(root);
        System.out.println("\npostorder using recursion:");
        postOrderRecursion(root);
        System.out.println("\npostorder using stack:");
        postOrderUsingStack(root);
        System.out.println("\ninorder using recursion:");
        inOrderRecursion(root);
        System.out.println("\ninorder using stack:");
        inOrderUsingStack(root);
        System.out.println("\ninorder using stack better version:");
        inOrderUsingStackBetterVersion(root);
        System.out.println("\nlevel order using queue:");
        levelOrder(root);
        System.out.println("\nlevel order spiral using 1 stack:");
        levelOrderLSpiralUsingOneStacks(root);
        System.out.println("\nlevel order spiral using 2 stack:");
        levelOrderLSpiralUsingTwoStacks(root);
    }

    public static void preOrderRecursion(TreeNode root) {
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preOrderRecursion(root.left);
        preOrderRecursion(root.right);
    }

    public static void postOrderRecursion(TreeNode root) {
        if(root==null)
            return;
        postOrderRecursion(root.left);
        postOrderRecursion(root.right);
        System.out.print(root.data+" ");
    }

    public static void inOrderRecursion(TreeNode root) {
        if(root==null)
            return;
        inOrderRecursion(root.left);
        System.out.print(root.data+" ");
        inOrderRecursion(root.right);
    }

    public static void preOrderUsingStack(TreeNode root) {
        if(root==null)
            return;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode node = s.pop();
            System.out.print(node.data+" ");
            if(node.right!=null){
                s.push(node.right);
            }
            if(node.left!=null) {
                s.push(node.left);
            }
        }
    }

    public static void postOrderUsingStack(TreeNode root) {
        if(root==null)
            return;
        Stack<TreeNode> s = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode node = s.pop();
            arr.add(node.data);
            if(node.left!=null){
                s.push(node.left);
            }
            if(node.right!=null) {
                s.push(node.right);
            }
        }
        for(int i=arr.size()-1;i>=0;i--){
            System.out.print(arr.get(i)+" ");
        }
    }

    public static void inOrderUsingStack(TreeNode root) {
        if(root==null)
            return;
       Stack<TreeNode> s = new Stack<>();
       s.push(root);
        while(root.left != null) {
            root= root.left;
            s.push(root);
        }
       while(!s.isEmpty()) {
           TreeNode poppedNode = s.pop();
           System.out.print(poppedNode.data+" ");
           if(poppedNode.right !=null) {
               TreeNode poppedNodeRight = poppedNode.right;
               s.push(poppedNodeRight);
               while(poppedNodeRight.left!=null) {
                   poppedNodeRight = poppedNodeRight.left;
                   s.push(poppedNodeRight);
               }
           }
       }
    }

    public static void inOrderUsingStackBetterVersion(TreeNode root) {
        if(root==null)
            return;
        Stack<TreeNode> s = new Stack<>();

        s.push(root);
        TreeNode curr = root.left;
        while (!s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
        }
    }

    public static void levelOrder(TreeNode root) {
        if(root==null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            if(node !=null) {
                System.out.print(node.data+" ");
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            } else {
                if(!q.isEmpty())
                    q.add(null);
            }
        }
    }

    public static void levelOrderLSpiralUsingOneStacks(TreeNode root) {
        if(root==null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        boolean flag= true;
        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            if(node !=null) {
                if(flag)
                    System.out.print(node.data+" ");
                else
                    s.push(node.data);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            } else {
                if(!q.isEmpty())
                    q.add(null);
                while(!s.isEmpty())
                    System.out.print(s.pop()+" ");
                flag = !flag;
            }
        }
    }

    public static void levelOrderLSpiralUsingTwoStacks(TreeNode root)
    {
        if(root==null)
            return;
        Stack<TreeNode> s1= new Stack<TreeNode>();
        Stack<TreeNode> s2= new Stack<TreeNode>();
        s1.push(root);
        while(!s1.isEmpty())
        {
            while(!s1.isEmpty())
            {
                TreeNode poppedElement= s1.pop();
                System.out.print(poppedElement.data + " ");
                if(poppedElement.left !=null)
                {
                    s2.add(poppedElement.left);
                }
                if(poppedElement.right !=null)
                {
                    s2.add(poppedElement.right);
                }
            }
            while(!s2.isEmpty())
            {
                TreeNode poppedElement= s2.pop();
                System.out.print(poppedElement.data + " ");

                if(poppedElement.right !=null)
                {
                    s1.add(poppedElement.right);
                }
                if(poppedElement.left !=null)
                {
                    s1.add(poppedElement.left);
                }

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

