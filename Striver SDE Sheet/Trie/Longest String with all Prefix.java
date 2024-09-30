import java.util.* ;
import java.io.*; 

class Solution {
  class Trie {
    private Node root;
    
    Trie() {
      root = new Node();
    }

    class Node {
      Node[] links;
      Boolean flag = false;
      
      Node() {
        links = new Node[26];
      }
      
      void put(char ch, Node node) {
        links[ch - 'a'] = node;
      }
      
      Boolean containsKey(char ch) {
        return links[ch - 'a'] != null; 
      }
      
      Node get(char ch) {
        return links[ch - 'a'];
      }
      
      void setEnd() {
        flag = true;
      }
      
      Boolean isEnd() {
        return flag;
      }
    }

    // Insert method inside the Trie class
    void insert(String str) {
      Node node = root;
      for (char ch : str.toCharArray()) {
        if (!node.containsKey(ch)) {
          node.put(ch, new Node());
        }
        node = node.get(ch);
      }
      node.setEnd();
    }

    // Corrected containsPrefix method inside the Trie class
    Boolean containsPrefix(String str) {
      Node node = root;
      Boolean flag = true;
      for (char ch : str.toCharArray()) {
        if (node.containsKey(ch)) {
          node = node.get(ch);
          flag = flag && node.isEnd();
        } else {
          return false;
        }
        if(!flag) return flag;
      }
      return flag;
    }
  }

  public static String completeString(int n, String[] a) {
    // Write your code here.
    Trie trie = new Solution().new Trie();  // Create a new Trie object
    for (String str : a) {
      trie.insert(str);
    }

    String longest = "";
    for (String str : a) {
      Boolean containsPrefix = trie.containsPrefix(str);
      if (containsPrefix && str.length() > longest.length()) {
        longest = str;
      }
      else if(containsPrefix && str.length()==longest.length() && str.compareTo(longest)<0)
        longest = str;
    }
    return longest.equals("") ? "None" : longest;  // Handle case when no valid word found
  }
}
