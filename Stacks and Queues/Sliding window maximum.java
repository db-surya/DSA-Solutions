class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
     int index = 0;
     Deque<Integer>queue = new ArrayDeque<>();
     int ans[] = new int[nums.length-k+1];
     for(int i=0;i<nums.length;i++){
        if(!queue.isEmpty() && queue.peek()<=i-k){
            queue.poll();
        }
        while(!queue.isEmpty() && nums[i]>nums[queue.peekLast()]){
            queue.pollLast();
        }
        queue.add(i);
        if(i>=k-1){
            ans[index++]=nums[queue.peek()];
        }
     }
     return ans;
    }
}