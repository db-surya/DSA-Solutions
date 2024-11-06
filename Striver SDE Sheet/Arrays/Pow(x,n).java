class Solution {
    public double myPow(double x, int n) {
        long nn = n;
        if(n<0) nn = -1*nn;
        double ans = 1.0;
        while(nn>0)
        {
            if(nn%2==1)
            {
                ans = ans*x;
                nn = nn-1;
            }
            else
            {
                x = x*x;
                nn = nn/2;
            }
        }
        if(n<0) ans = (double)(1.0)/(double)(ans);
        return ans;
    }
}