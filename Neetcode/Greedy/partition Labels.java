class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        int end  = -1;
        int size = 0;
        List<Integer>ans = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int localEnd = map.get(c);
            end = Math.max(end,localEnd);
            size++;
            if(end==i){ 
                ans.add(size);
                end = i;
                size = 0;
            }
        }
        return ans;
    }
}

/*Good question 
 * Hashmap to check the last occurence of the characters
 * Iterate and check if the curr index is last occurence of all guys in previous batch
 * Add this to result and repeat
 */