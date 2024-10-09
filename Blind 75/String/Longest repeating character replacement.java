class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0,right = 0;
        int hash[] = new int[26];
        int maxLen = 0, maxFreq = 0;
        while(right<s.length()){
            hash[s.charAt(right)-'A']++;
            maxFreq = Math.max(hash[s.charAt(right)-'A'],maxFreq);
            if((right-left+1-maxFreq)>k){
                hash[s.charAt(left)-'A']--;
                left++;
            }
            maxLen = Math.max(right-left+1,maxLen);
            right++;
        }
        return maxLen;
    }
}