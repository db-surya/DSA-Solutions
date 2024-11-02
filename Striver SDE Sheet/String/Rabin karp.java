class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = 1;
        String source = a;
        while(a.length() < b.length())
        {
            count++;
            a+=source;
        }
        if(a.equals(b))
            return count;
        if(RabinKarp(a,b))
            return count;
        if(RabinKarp(a+source,b))
            return count+1;
        return -1;
    }
    public Boolean RabinKarp(String a, String b)
    {
        int BASE = 1000000;
        int m = b.length();
        int n = a.length();
        int power = 1;
        for(int i=0;i<m;i++)
        {
            power = (power*31)%BASE;
        }
        int targetCode = 0;
        for(int i=0;i<m;i++)
        {
            targetCode = ((targetCode*31)+b.charAt(i))%BASE;
        }
        int hashCode = 0;
        for(int i=0;i<n;i++)
        {
            hashCode = ((hashCode*31)+a.charAt(i))%BASE;
            if(i<m-1)
                continue;
            if(i>=m)
                hashCode = (hashCode-(a.charAt(i-m)*power))%BASE;
            if(hashCode < 0)
                hashCode+= BASE;
            if(hashCode == targetCode)
            {
                if(b.equals(a.substring(i-m+1,i+1)))
                {
                    return true;
                }
            }
        }
        return false;
    }
}