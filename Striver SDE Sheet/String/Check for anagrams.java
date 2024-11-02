class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray())
        {
            map.put(x, map.getOrDefault(x,0)+1);
        }
        for(char x: t.toCharArray())
        {
            map.put(x, map.getOrDefault(x,0)-1);
        }
        for(int x: map.values())
        {
            if(x!=0)
                return false;
        }
        return true;
    }
}