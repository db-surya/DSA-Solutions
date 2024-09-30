class Solution {
    class Trie {
        Node root;
        
        Trie() {
            root = new Node();
        }

        class Node {
            Node[] links;
            
            Node() {
                links = new Node[2];
            }

            Boolean containsKey(int bit) {
                return links[bit] != null;
            }

            void put(int bit, Node node) {
                links[bit] = node;
            }

            Node get(int bit) {
                return links[bit];
            }
        }

        // Insert a number into the Trie
        void insert(int num) {
            Node node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (!node.containsKey(bit)) {
                    node.put(bit, new Node());
                }
                node = node.get(bit);
            }
        }

        // Get the maximum XOR for a given number
        int getMax(int num) {
            Node node = root;
            int maxSum = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.containsKey(1 - bit)) {
                    maxSum |= (1 << i); // Set the current bit in maxSum
                    node = node.get(1 - bit);
                } else {
                    node = node.get(bit);
                }
            }
            return maxSum;  // Add return statement here to return the calculated maxSum
        }
    }

    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int i = 0; i < nums.length; i++) {
            trie.insert(nums[i]);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, trie.getMax(nums[i]));
        }

        return max;
    }
}
