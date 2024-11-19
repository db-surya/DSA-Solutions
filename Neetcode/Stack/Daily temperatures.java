class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]>stack = new Stack<>();
        int ans[] = new int[temperatures.length];
        Arrays.fill(ans,0);
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]){
                int curr[] = stack.pop();
                ans[curr[1]] = i-curr[1];
            }
            stack.push(new int[]{temperatures[i],i});
        }
        return ans;
    }
}