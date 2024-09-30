public class Solution {
    public int solve(int[] A, int B) {
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,1);
        int xr = 0;
        int count = 0;
        for(int i=0;i<A.length;i++){
            xr = A[i]^xr;
            if(map.containsKey(xr^B)){
                count+=map.get(xr^B);
            }
            map.put(xr, map.getOrDefault(xr,0)+1);
        }
        return count;
    }
}
