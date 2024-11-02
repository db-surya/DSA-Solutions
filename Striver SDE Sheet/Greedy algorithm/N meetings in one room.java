class Meeting
{
    int start;
    int end;
    int pos;
    Meeting(int _start, int _end, int _pos)
    {
        this.start = _start;
        this.end = _end;
        this.pos = _pos;
    }
}
class meetingComparator implements Comparator<Meeting>
{
    public int compare(Meeting a, Meeting b)
    {
        if(a.end < b.end)
            return -1;
        else if(a.end > b.end)
            return 1;
        else if(a.pos < b.pos)
            return -1;
        return 1;
    }
    
}
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<Meeting> meets = new ArrayList<>();
        for(int i=0;i<start.length;i++)
        {
            meets.add(new Meeting(start[i],end[i],i+1));
        }
        meetingComparator mc = new meetingComparator();
        Collections.sort(meets,mc);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(meets.get(0).pos);
        int lastFinishTime = meets.get(0).end;
        for(int i=1;i<meets.size();i++)
        {
            if(meets.get(i).start > lastFinishTime)
            {
                ans.add(meets.get(i).pos);
                lastFinishTime = meets.get(i).end;
            }
        }
        return ans.size();
    }
}