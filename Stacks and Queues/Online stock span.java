class Pair{
    int val;
    int span;
    Pair(int v, int s){
        this.val = v;
        this.span = s;
    }
}
class StockSpanner {
    Stack<Pair>stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int currSpan = 1;
        if(stack.isEmpty()){
            stack.push(new Pair(price,1));
        }
        else{
            while(!stack.isEmpty() && stack.peek().val<=price){
                Pair p = stack.pop();
                currSpan+= p.span;
            }
            stack.push(new Pair(price,currSpan));
        }
        return currSpan;
    }
}