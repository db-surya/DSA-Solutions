class Solution {
    public int DFS(int index, int d, int curr_max, HashMap<String,Integer>cache,int[] jobDifficulty){
        int N = jobDifficulty.length;
        if(index==N && d!=0) return Integer.MAX_VALUE;
        if(index==N && d==0) return 0;
        if(d==0) return Integer.MAX_VALUE;
        String keyString = index+" "+d+" "+curr_max;
        if(cache.containsKey(keyString)) return cache.get(keyString);
        curr_max = Math.max(curr_max,jobDifficulty[index]);
        int breakDay = DFS(index+1, d-1, -1, cache, jobDifficulty);
        int notBreakDay = DFS(index+1, d, curr_max, cache,jobDifficulty);
        int res = 0;
        if(breakDay!=Integer.MAX_VALUE){
            res = Math.min(curr_max+breakDay,notBreakDay);
        }
        else res = notBreakDay;
        cache.put(keyString,res);
        return res;
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(d>jobDifficulty.length) return -1;
        HashMap<String,Integer>cache = new HashMap<>();
        return DFS(0,d,-1,cache,jobDifficulty);
    }
}