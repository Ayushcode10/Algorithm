package MTE.LinkedList;

import jdk.jshell.spi.SPIResolutionException;

import java.security.PublicKey;

public class LinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        addLast(1);
        addLast(2);
        addLast(3);
        addLast(4);
        display();
    }
    public static Node head;
    public static int size;
    public LinkedList(){
        size = 0;
    }

    public static void addfirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }
    public static void addLast(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        size++;
    }

    public static void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
}
