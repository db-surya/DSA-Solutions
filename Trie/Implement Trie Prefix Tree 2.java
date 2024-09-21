import java.util.* ;
import java.io.*; 
public class Trie {
    class Node{
        Node[] links;
        int cntEndWith;
        int cntPrefix;
        Node(){
            links = new Node[26];
            cntEndWith = 0;
            cntPrefix = 0;
        }
        boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }
        Node getNode(char ch){
            return links[ch-'a'];
        }
        void put(char ch, Node node){
            links[ch-'a'] = node;
        }
        void increaseEnd(){
            cntEndWith++;
        }
        void increasePrefix(){
            cntPrefix++;
        }
        void deleteEnd(){
            cntEndWith--;
        }
        void reducePrefix(){
            cntPrefix--;
        }
    }
    private Node root;
    public Trie() {
        // Write your code here.
        root = new Node();
    }

    public void insert(String word) {
        // Write your code here.
        Node node = root;
        for(char ch: word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch, new Node());
            }
            node = node.getNode(ch);
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node node = root;
        for(char ch:word.toCharArray()){
            if(node.containsKey(ch)){
                node = node.getNode(ch);
            }
            else
                return 0;
        }
        return node.cntEndWith;
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node node = root;
        for(char ch:word.toCharArray()){
            if(node.containsKey(ch)){
                node = node.getNode(ch);
            }
            else
                return 0;
        }
        return node.cntPrefix;
    }

    public void erase(String word) {
        // Write your code here.
        Node node = root;
        for(char ch:word.toCharArray()){
            if(node.containsKey(ch)){
                node = node.getNode(ch);
                node.reducePrefix();
            }
            else
                return;
        }
        node.deleteEnd();
        return;
    }

}
