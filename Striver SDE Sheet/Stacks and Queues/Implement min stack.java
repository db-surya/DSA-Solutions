class MinStack {
    Stack<Long>stack = new Stack<>();
    Long min = Long.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int val) {
        Long value = (long)val;
        if(stack.isEmpty()){
            min = value;
            stack.push(value);
        }
        else if(value<min){
            Long x = (2*value)-min;
            min = value;
            stack.push(x);
        }
        else
            stack.push(value);
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        Long value = stack.pop();
        if(value<min){
            min = 2*min-value;
        }
    }
    
    public int top() {
        Long value = stack.peek();
        if(value<min){
            return min.intValue();
        }
        return value.intValue();
    }
    
    public int getMin() {
        return min.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */