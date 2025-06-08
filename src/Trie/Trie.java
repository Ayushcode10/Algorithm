package Trie;

class Node{
    Node[] links = new Node[26]; //for 26 lowercase eng letters
    boolean flag = false;// to mark the end of a word
    int cntPrefix = 0;
    int cntEndsWith = 0;
    public Node(){

    }


    //checks if there is a node for this char or not
    boolean containsKey(char ch){
        return (links[ch - 'a'] != null);
    }

    //creates a link from the curr node to a new node for char ch
    public void put(char ch, Node node){
        links[ch - 'a'] = node;
    }

    //gets the reference(link) to the next node for ch
    public Node get(char ch){
        return links[ch-'a'];
    }

    //marks that the curr node is the end of a word
    public void setEnd() {
        flag = true;
    }

    public boolean isEnd(){
        return flag;
    }

    public void increaseEnd(){
        cntEndsWith++;
    }
    public void increasePre(){
        cntPrefix++;
    }
    public void deleteEnd(){
        cntEndsWith--;
    }
    public void reducePre(){
        cntPrefix--;
    }
    public int getEnd(){
        return cntEndsWith;
    }
    public int getPre(){
        return cntPrefix;
    }

}
public class Trie {
    //this is the starting point, (empty node before any char is added)
    private static Node root;

    //initialise the data structure by creating the root node
    public Trie(){
        root = new Node();
    }

    //inserts a word into the trie
    //tc-->(O(n)), n = word.length();
    void insert(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            //if the char doesn't exist then insert
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            //moves to the new reference trie, (moves the node ptr to curr node)
            node = node.get(word.charAt(i));
            node.increasePre();
        }
        //sets the end of the word as true
        node.setEnd();
        node.increaseEnd();
    }

    public int countWordsEqualTo(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else{
                return 0;
            }
        }
        return node.getEnd();
    }
    boolean search(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        //if it is true then we have got the entire word
        return node.isEnd();
    }

    boolean StartsWith(String prefix){
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if(!node.containsKey(prefix.charAt(i))){
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }

    int countWordsStartWith(String word){
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

    public void erase(String word){
        if (!search(word)) return; // only erase if word exists
        Node node = root;
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
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("apple");
        trie.insert("apple");
        trie.insert("apple");
        trie.insert("cat");
        trie.insert("car");
        trie.insert("care");
        trie.insert("dog");
        trie.insert("doll");

        // Test search
        System.out.println(trie.search("cat"));     // true
        System.out.println(trie.search("care"));    // true
        System.out.println(trie.search("can"));     // false
        System.out.println(trie.search("do"));      // false

        // Test startsWith
        System.out.println(trie.StartsWith("ca"));  // true
        System.out.println(trie.StartsWith("car")); // true
        System.out.println(trie.StartsWith("d"));   // true
        System.out.println(trie.StartsWith("z"));   // false

        //test countEW
        System.out.println(trie.countWordsEqualTo("apple"));
    }
}
