class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // Clone the queries array with original indices
        int[][] queryWithIndices = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            queryWithIndices[i][0] = queries[i];
            queryWithIndices[i][1] = i;
        }

        // Sort queries by their value
        Arrays.sort(queryWithIndices, (a, b) -> Integer.compare(a[0], b[0]));

        // Sort intervals by their start time
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        // Min heap to track intervals, sorted by size and then end time
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        int[] result = new int[queries.length];
        Arrays.fill(result, -1);

        int j = 0; // Pointer for intervals
        for (int[] query : queryWithIndices) {
            int currQuery = query[0];
            int originalIndex = query[1];

            // Add all intervals that cover the current query to the heap
            while (j < intervals.length && intervals[j][0] <= currQuery) {
                if (intervals[j][1] >= currQuery) {
                    int size = intervals[j][1] - intervals[j][0] + 1;
                    minHeap.add(new int[]{size, intervals[j][1]});
                }
                j++;
            }

            // Remove intervals from the heap that no longer cover the current query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < currQuery) {
                minHeap.poll();
            }

            // If the heap is not empty, get the smallest interval
            if (!minHeap.isEmpty()) {
                result[originalIndex] = minHeap.peek()[0];
            }
        }

        return result;
    }
}
