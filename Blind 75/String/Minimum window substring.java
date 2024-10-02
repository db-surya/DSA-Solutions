class Solution {
    public String minWindow(String s, String t) {
        int min = s.length() + 1, startIndex = 0;
        int n = s.length(), m = t.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0, count = 0;
        
        while (right < n) {
            while (count < m && right < n) {
                char c = s.charAt(right);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) >= 0) count++; // Only increase count if it's part of `t`
                }
                right++;
            }
            
            while (count == m) {
                // Update minimum window if found
                if (right - left < min) {
                    min = right - left;
                    startIndex = left;
                }

                // Slide left pointer and adjust the count
                char c = s.charAt(left);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) > 0) count--; // Only decrease count if it's below the needed amount
                }
                left++;
            }
        }
        
        return min == s.length() + 1 ? "" : s.substring(startIndex, startIndex + min);
    }
}
