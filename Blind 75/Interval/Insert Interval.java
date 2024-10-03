class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        // Add all intervals before the newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the merged interval
        list.add(newInterval);

        // Add the remaining intervals
        while (i < n) {
            list.add(intervals[i]);
            i++;
        }

        // Convert the list back to a 2D array
        return list.toArray(new int[list.size()][]);
    }
}
