package Set_Map;


public class DesignHashMap {
    public static void main(String[] args) {

    }

    private static Node head;
    private static class Node{
        int key;
        int val;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    //using linked list

    public DesignHashMap(){
        head = null;
    }
    public static void put(int key, int val){
        if(head == null){
            head = new Node(key,val);
            return;
        }
        Node curr = head;
        while(curr != null){
            if(curr.key == key){
                curr.val = val;
                return;
            }
            if(curr.next == null){
                curr.next = new Node(key,val);
                return;
            }
            curr = curr.next;
        }
    }
    public static int get(int key){
        Node curr = head;
        while (curr != null){
            if(curr.key == key){
                return curr.val;
            }
            curr = curr.next;
        }
        return -1;
    }
    public static void remove(int key){
        if(head == null){
            return;
        }
        if(head.key == key){
            head = head.next;
            return;
        }
        Node curr = head;
        while (curr.next != null){
            if(curr.next.key == key){
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

}
