class Solution {
    class Trie {
        class Node {
            Node[] links = new Node[26]; 
            boolean flag = false;
            public Node() { 
            }
            public Boolean containsChar(char ch) {
                return links[ch - 'a'] != null;
            }
            public void put(char ch, Node curr) {
                links[ch - 'a'] = curr;
            }
            public Node getNext(char ch) {
                return links[ch - 'a'];
            }
            public void markEnd() {
                flag = true;
            }
            public Boolean isEnd() {
                return flag;
            }
        }
        private Node root;
        public Trie() { 
            root = new Node();
        }
        public void insert(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                if (!curr.containsChar(ch)) {
                    curr.put(ch, new Node());
                }
                curr = curr.getNext(ch);
            }
            curr.markEnd();
        }
    }
    
    public void DFS(char[][] board, int i, int j, Trie.Node curr, StringBuilder str, HashSet<String> set, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) return;
        char ch = board[i][j];
        if (!curr.containsChar(ch)) return;
        
        curr = curr.getNext(ch);
        str.append(ch);
        if (curr.isEnd()) set.add(str.toString());
        
        visited[i][j] = true;
        
        DFS(board, i, j - 1, curr, str, set, visited);  // Left
        DFS(board, i - 1, j, curr, str, set, visited);  // Up
        DFS(board, i, j + 1, curr, str, set, visited);  // Right
        DFS(board, i + 1, j, curr, str, set, visited);  // Down
        
        visited[i][j] = false;
        str.deleteCharAt(str.length() - 1);
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie t = new Trie();
        for (String word : words) {
            t.insert(word);
        }
        HashSet<String> set = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {  
                Trie.Node curr = t.root;
                DFS(board, i, j, curr, new StringBuilder(), set, visited);
            }
        }
        return new ArrayList<>(set);
    }
}
