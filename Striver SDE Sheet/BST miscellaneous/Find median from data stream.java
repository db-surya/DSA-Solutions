class MedianFinder {
    PriorityQueue<Integer>left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer>right = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        //Adding to correct heap based on checking the peek element
        //And checking where they belong
        if(left.size()==0) 
            left.add(num);
        else if(num < left.peek()) 
            left.add(num);
        else
            right.add(num);
        //Shifting if size doesn't match
        if(left.size()-right.size()>1){
            int temp = left.remove();
            right.add(temp); 
        }       
        if(right.size()-left.size()>1){
            int temp = right.remove();
            left.add(temp);
        }
    }
    
    public double findMedian() {
        if(left.size()==right.size()){
            return (left.peek()+right.peek())/2.0;
        }
        else if(left.size()>right.size())
            return left.peek();
        else
            return right.peek();
    }
}