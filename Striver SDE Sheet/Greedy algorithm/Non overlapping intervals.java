class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingDouble(o->o[1]));
        int last = intervals[0][1];
        int count = 1;
        for(int i=1;i<n;i++){
            if(intervals[i][0]>=last){
                count++;
                last =  intervals[i][1];
            }
        }
        return n-count;
    }
}