class KthLargest {
    PriorityQueue<Integer>minHeap = new PriorityQueue<>();
    int kValue;
    public KthLargest(int k, int[] nums) {
        this.kValue = k;
        for(int num:nums){
            minHeap.add(num);
        }
        int count = k;
        while(minHeap.size()>k){
            minHeap.remove();
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size()>kValue)
            minHeap.remove();
        return minHeap.peek();
    }
}