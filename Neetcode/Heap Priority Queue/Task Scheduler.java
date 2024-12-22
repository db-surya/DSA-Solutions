class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] alphabetsCount = new int[26];
        for (char c : tasks) {
            alphabetsCount[c - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : alphabetsCount) {
            if (count > 0) {
                maxHeap.add(count);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            //Max heap checking should come first
            if (!maxHeap.isEmpty()) {
                int currTask = maxHeap.poll();
                if (currTask - 1 > 0) {
                    queue.add(new int[] { currTask - 1, time + n });
                }
            }
            //This should come second otherwise the idle time won't be calculated properly
            if (!queue.isEmpty() && queue.peek()[1] <= time) {
                maxHeap.add(queue.poll()[0]);
            }
        }

        return time;
    }
}
