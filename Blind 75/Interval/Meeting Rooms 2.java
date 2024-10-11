class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int N = intervals.size();
        int start[] = new int[N];
        int end[] = new int[N];
        for(int i=0;i<N;i++){
            start[i] = intervals.get(i).start;
            end[i] =  intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int startPointer = 0, endPointer = 0, count = 0;
        int max = 0;
        while(startPointer<N && endPointer<N){
            if(start[startPointer]>=end[endPointer]){
                endPointer++;
                count--;
            }
            else{
                startPointer++;
                count++;
            }
            max = Math.max(count,max);
        }
        return max;
    }
}