class Solution {
    public Boolean DFS(String word, HashSet<String> set, HashMap<String, Boolean> memo) {
        if (memo.containsKey(word)) {
            return memo.get(word);
        }
        
        int n = word.length();
        for (int i = 1; i < n; i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i, n);
            
            if (set.contains(prefix) && (set.contains(suffix) || DFS(suffix, set, memo))) {
                memo.put(word, true);
                return true;
            }
        }
        
        memo.put(word, false);
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        List<String> ans = new ArrayList<>();
        HashMap<String, Boolean> memo = new HashMap<>();
        
        for (String word : words) {
            if (DFS(word, set, memo)) {
                ans.add(word);
            }
        }
        
        return ans;
    }
}
