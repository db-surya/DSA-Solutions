class Trie {
    class Node {
        Node[] links = new Node[26];
        Boolean flag = false;
    public boolean containsCharacter(char c) {
        return links[c - 'a'] != null;
    }

    public void put(char c, Node nextNode){
         links[c-'a']=nextNode;
    }

    public Node getNextNode(char c){
        return links[c-'a'];
    }
    public void setEnd(){
        flag = true;
    }
    public boolean isEnd(){
        return flag;
    }
    }

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for(char c: word.toCharArray()){
            if(!current.containsCharacter(c)){
                current.put(c, new Node());
            }
            current = current.getNextNode(c);
        }
        current.setEnd();
    }

    public boolean search(String word) {
        Node current = root;
        for(char c: word.toCharArray()){
            if(!current.containsCharacter(c)) return false;
            current = current.getNextNode(c);
        }
        return current.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node current = root;
        for(char c:prefix.toCharArray()){
            if(!current.containsCharacter(c))
                return false;
            current = current.getNextNode(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */