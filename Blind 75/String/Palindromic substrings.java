class Solution {
    public int countSubstrings(String s) {
        char str[] = s.toCharArray();
        int count = 0;
        for(int i=0;i<str.length;i++)
        {
            //odd palindrome
            int left = i;
            int right = i;
            while(left >=0 && right<str.length && str[left]==str[right])
            {
                count++;
                left--;
                right++;
            }
            //even palindrome
            left = i;
            right = i+1;
            while(left >=0 && right<str.length && str[left]==str[right])
            {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}