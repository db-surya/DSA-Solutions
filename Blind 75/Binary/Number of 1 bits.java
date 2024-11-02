public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0)
        {
            count+=(n%2)&1;
            n>>>=1;   // right shift with zeros
        }
        return count;
    }
}