package Trie;

class Node2{
    Node2[] links = new Node2[26];
    boolean flag = false;
    int cntEw = 0;
    int cntPre = 0;
    Node2(){

    }


    public boolean containsKey(char c) {
        return links[c-'a'] != null;
    }

    public void put(char c, Node2 node2) {
        links[c - 'a'] = node2;
    }

    public Node2 get(char c) {
        return links[c-'a'];
    }

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }
    public void increaseEnd() {
        cntEw++;
    }

    public void increasePre() {
        cntPre++;
    }

    public int getPre() {
        return cntPre;
    }

    public int getEnd() {
        return cntEw;
    }

    public void reducePre() {
        cntPre--;
    }

    public void deleteEnd() {
        cntEw--;
    }
}
public class triee {
    private static Node2 root;
    triee(){
        root = new Node2();
    }
    //insert
    void insert(String word){
        Node2 node = root;
        for (int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node2());
            }
            node = node.get(word.charAt(i));
            node.increasePre();
        }
        node.setEnd();
        node.increaseEnd();
    }

    //search
    boolean search(String word){
        Node2 node = root;
        for (int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }

    int countWordStartsWith(String word){
        Node2 node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else{
                return 0;
            }
        }
        return node.getPre();
    }
    int countWordEqualTo(String word){
        Node2 node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else{
                return 0;
            }
        }
        return node.getEnd();
    }

    boolean startWith(String prefix){
        Node2 node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if(!node.containsKey(prefix.charAt(i))){
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }

    void erase(String word){
        if(!search(word)) return;
        Node2 node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                node.reducePre();
            }else{
                return;
            }
        }
        node.deleteEnd();
    }
    public static void main(String[] args) {
        triee  t = new triee();
        t.insert("apple");
        t.insert("apple");
        t.insert("apple");
        t.erase("apple");
        t.insert("appl");
        t.insert("appe");
        t.insert("apps");

        System.out.println(t.search("apple"));
        System.out.println(t.countWordEqualTo("apple"));
        System.out.println(t.startWith("apep"));
    }
}
