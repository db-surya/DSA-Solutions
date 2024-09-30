class MedianFinder {
    PriorityQueue<Integer>left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer>right = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(left.size()==0) left.add(num);
        else if(num<left.peek()) left.add(num);
        else right.add(num);
        if(left.size()-right.size()>1){
            int temp = left.poll();
            right.add(temp);
        }
        else if(right.size()-left.size()>1){
            int temp = right.poll();
            left.add(temp);
        }
    }
    
    public double findMedian() {
        if(left.size()==right.size())
            return (left.peek()+right.peek())/2.0;
        else if(left.size()>right.size())
            return left.peek();
        else
            return right.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */