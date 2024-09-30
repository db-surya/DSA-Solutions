class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int p1=0;
        int p2=0;
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(p2<s.length && p1<g.length){
            if(g[p1]<=s[p2]){
                count++;
                p1++;
            }
            p2++;
        }
        return count;
    }
}