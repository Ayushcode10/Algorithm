// Node class
package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        left = right = null;
    }
}

// BinaryTree class
public class Main {
    Node root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value)
            root.left = insertRec(root.left, value);
        else if (value > root.value)
            root.right = insertRec(root.right, value);

        return root;
    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    public void preorder() {
        System.out.print("Preorder: ");
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    public void postorder() {
        System.out.print("Postorder: ");
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.value + " ");
        }
    }

    public int height(){
        return HeightRec(root);
    }

    private int HeightRec(Node root){
        if(root == null){
            return 0;
        }
        int lh = HeightRec(root.left);
        int rh = HeightRec(root.right);
        return 1+ Math.max(lh,rh);
    }

    private static void printK(Node root, int k, ArrayList<Integer> list){
        if(root == null) return;
        if(k == 0){
            list.add(root.value);
        }
        else{
            printK(root.left, k-1,list);
            printK(root.right, k-1,list);
        }
    }
    public ArrayList<Integer> printKthLevel(int k) {
        ArrayList<Integer> list = new ArrayList<>();
        printK(root, k, list);
        System.out.println("Nodes at level " + k + ": " + list);
        return list;
    }

    public void levelOrderTraversal(){
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        System.out.println("Level Order Traversal: ");
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            System.out.println(curr.value + " ");
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Main tree = new Main();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.print("Inorder traversal: ");
        tree.inorder();
        System.out.print("Preorder traversal: ");
        tree.preorder();
        System.out.print("Postorder traversal: ");
        tree.postorder();
        System.out.println(tree.height());
        tree.printKthLevel(2);
        tree.levelOrderTraversal();
    }
}
