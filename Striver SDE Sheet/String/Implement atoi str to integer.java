class Solution {
    public int myAtoi(String s) {
        if (s.isEmpty()) return 0;
        int i = 0;
        int base = 0;
        int sign = 1;
        while(i<s.length()-1 && s.charAt(i)==' ')
            i++;
        if(i<s.length() && s.charAt(i)=='+' || s.charAt(i)=='-')
            sign = s.charAt(i++)=='-'?-1:1;
        while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9')
        {
                if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10))
                {
                    return sign == -1? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                base = base*10 + s.charAt(i)-'0';
                i++;
        }   
        return sign*base;
    }
}