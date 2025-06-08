package Greedy;
class Node{
    Node[] links = new Node[26];
    boolean flag = false;
    int cntEW = 0;
    int cntPRE = 0;

    public boolean containsKey(char c) {
        return links[c-'a'] != null;
    }

    public void put(char c, Node node) {
        links[c-'a'] = node;
    }

    public Node get(char c) {
        return links[c-'a'];
    }

    public void setEnd() {
        flag = true;
    }

    public void increaseEnd() {
        cntEW++;
    }

    public void increasePre() {
        cntPRE++;
    }

    public boolean isEnd() {
        return flag;
    }

    public int getEnd() {
        return cntEW;
    }

    public int getPre() {
        return cntPRE;
    }

    public void reducePre() {
        cntPRE--;
    }

    public void deleteEw() {
        cntEW--;
    }
}
class trie{
    private static Node root;
    trie(){
        root = new Node();
    }
    //insert
    void insert(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.increasePre();
        }
        node.setEnd();
        node.increaseEnd();
    }

    //counts word equal to
    int countWordEqualsTo(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else{
                return 0;
            }
        }
        return node.getEnd();
    }
    //search
    boolean search(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }
    //starts with
    boolean startsWith(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return true;
    }

    int countWordsStartingWith(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else{
                return 0;
            }
        }
        return node.getPre();
    }

    void erase(String word){
        if(!search(word)) return;
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                node.reducePre();
            }else{
                return;
            }
        }
        node.deleteEw();
    }

    public static void main(String[] args) {
        trie t = new trie();
        t.insert("apple");
        t.insert("apple");
        t.insert("apple");
        t.insert("apple");
        t.insert("apps");
        t.insert("appex");
        t.insert("app");

        System.out.println(t.countWordEqualsTo("apple"));
        System.out.println(t.countWordEqualsTo("app"));
    }
}