public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer>stack = new Stack<>();
        ArrayList<Integer>ans = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            int curr = A.get(i);
            while(!stack.isEmpty() && stack.peek()>=curr){
                stack.pop();
            }
            if(stack.isEmpty())
                ans.add(-1);
            else
            ans.add(stack.peek());
            stack.add(curr);
        }
        return ans;
    }
}
