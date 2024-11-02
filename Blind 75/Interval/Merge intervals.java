
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int a[], int b[])
            {
                return a[0]-b[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for(int i=0;i<intervals.length;i++)
        {
            if(ans.size()==0 || ans.get(ans.size()-1)[1] < intervals[i][0])
                ans.add(new int[]{intervals[i][0],intervals[i][1]});
            else
            {
                int temp[] = ans.get(ans.size()-1);
                int newEntry[] =  new int[]{temp[0], Math.max(temp[1],intervals[i][1])};
                ans.remove(ans.size()-1);
                ans.add(newEntry);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}