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
public int[] maximizeXor(int[] nums, int[][] queries) {
Trie trie = new Trie();
int offlineQueries[][] = new int[queries.length][3];
for (int i = 0; i < queries.length; i++) {
    offlineQueries[i][0] = queries[i][0];
    offlineQueries[i][1] = queries[i][1];
    offlineQueries[i][2] = i;
}
int ans[] = new int[queries.length];
Arrays.sort(nums);
Arrays.sort(offlineQueries, Comparator.comparingDouble(o -> o[1]));
int iter = 0;
for (int i = 0; i < queries.length; i++) {
    int maxLimit = offlineQueries[i][1];
    while (iter < nums.length && nums[iter] <= maxLimit) {
        trie.insert(nums[iter]);
        iter++;
    }
    if (iter == 0) {
        // If no elements from nums were inserted in the trie
        ans[offlineQueries[i][2]] = -1;
    } else {
        ans[offlineQueries[i][2]] = trie.getMax(offlineQueries[i][0]);
    }
}
return ans;
}
}