package Misc;

public class chainedLL {
    int size = 0;
    private Node head;
    chainedLL(){
        this.size = 0;
    }

    public void addnext(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next !=null){
            temp = temp.next;
        }
        temp.next = node;
        size++;
    }
    public void addBottom(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            return;
        }
        Node temp = head;
        while (temp.bottom!=null){
            temp = temp.bottom;
        }
        temp.bottom = node;
        size++;
    }
    public void display(){

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            Node bottomTemp = temp.bottom;
            while (bottomTemp != null) {
                System.out.print("[" + bottomTemp.val + "] ");
                bottomTemp = bottomTemp.bottom;
            }
            System.out.println();
            temp = temp.next;
        }
    }
    public static class Node{
        private int val;
        private Node next;
        private Node bottom;
        public Node(int val){
            this.val = val;
            this.next = null;
            this.bottom = null;
        }
        public Node(int val,Node next){
            this.val = val;
            this.next = next;
            this.bottom = null;
        }
        public Node(int val,Node next,Node bottom){
            this.val = val;
            this.next = next;
            this.bottom = bottom;
        }
    }
    public static void main(String[] args) {
        chainedLL ll = new chainedLL();
        ll.addnext(1);
        ll.addnext(2);
        ll.addnext(3);
        ll.head.bottom = new Node(4);
        ll.head.bottom.bottom = new Node(5);

        // Adding to bottom of node 2
        ll.head.next.bottom = new Node(6);
        ll.head.next.bottom.bottom = new Node(7);

        ll.display();
    }


}
