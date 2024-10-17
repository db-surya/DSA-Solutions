class WordDictionary {
    Node root;
    class Node{
        Node[] links = new Node[26];
        Boolean isEnd = false;
        Boolean containsChar(char c){
            return links[c-'a']!=null;
        }
        void put(char c, Node curr){
            links[c-'a'] = curr;
        }
        Node get(char c){
            return links[c-'a'];
        }
        Boolean isEnd(){
            return isEnd;
        }
        void markEnd(){
            isEnd = true;
        }
    }
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(char c:word.toCharArray()){
            if(!curr.containsChar(c)){
                curr.put(c,new Node());
            }
            curr = curr.get(c);
        }
        curr.markEnd();
    }
    
    public boolean search(String word) {
        Node curr = root;
        return searchHelper(curr,0,word);
    }
   public boolean searchHelper(Node curr, int index, String word) {
    if (index == word.length()) {
        return curr.isEnd();
    }
    char c = word.charAt(index);
    if (c == '.') {
        for (int i = 0; i < 26; i++) {
            if (curr.links[i] != null) {
                if (searchHelper(curr.links[i], index + 1, word)) {
                    return true;
                }
            }
        }
        return false; 
    } else {
        if (!curr.containsChar(c)) {
            return false;
        }
        curr = curr.get(c);
        return searchHelper(curr, index + 1, word); 
    }
}

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */