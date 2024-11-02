public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        long n = A.length;
        if(n==0)
            return new int[]{};
        int wrongSum = 0;
        int duplicate = 0;
        for(int i=0;i<n;i++)
        {
            int index = Math.abs(A[i])-1;
            if(A[index]<0)
                duplicate = index+1;
            A[index] = -A[index];
            wrongSum+= Math.abs(A[i]);
        }
        long correctSum = (n*(n+1))/2;
        long missing = correctSum-wrongSum+duplicate;
        return new int[]{(int)duplicate,(int)missing};
    }
}
