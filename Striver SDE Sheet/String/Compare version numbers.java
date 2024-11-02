class Solution {
    public int compareVersion(String version1, String version2) {
        char v1[] = version1.toCharArray();
        char v2[] = version2.toCharArray();
        int maxLength = Math.max(v1.length,v2.length);
        int i=0;
        int j=0;
        while(i<v1.length || j<v2.length)
        {
            int v1Num = 0;
            int v2Num = 0;
            while(i<v1.length)
            {
                if(v1[i]=='.')
                {
                    i++;
                    break;
                }
                v1Num = (v1Num*10)+(v1[i]-'0');
                i++;
            }
            while(j<v2.length)
            {
                if(v2[j]=='.')
                {
                    j++;
                    break;
                }
                v2Num = (v2Num*10)+(v2[j]-'0');
                j++;
            }
            if(v1Num > v2Num)
                return 1;
            else if(v1Num < v2Num)
                return -1;
        }
        return 0;
    }
}