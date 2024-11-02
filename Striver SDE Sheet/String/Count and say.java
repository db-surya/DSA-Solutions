class Solution {
    public String countAndSay(int n) {
        String prevResult = "1";
        for(int i=2;i<=n;i++)
        {
            String curr = "";
            char prev[] = prevResult.toCharArray();
            int count = 1;
            for(int j=0;j<prev.length;j++)
            {
                if(j!=prev.length-1 && prev[j]==prev[j+1])
                    count++;
                else
                {
                    curr+= count;
                    curr+= prev[j];
                    count = 1;
                }
            }
            prevResult = curr;
        }
        return prevResult;
    }
}