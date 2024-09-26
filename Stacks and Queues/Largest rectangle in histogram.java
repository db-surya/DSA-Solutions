class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer>stack = new Stack<>();
        int N = heights.length,maxArea = 0;
        for(int i=0;i<N;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                int element = stack.pop();
                int nextSmaller = i;
                int prevSmaller = !stack.isEmpty() ? stack.peek():-1;
                maxArea = Math.max(maxArea, heights[element]*(nextSmaller - prevSmaller -1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int nextSmaller = N;
            int element = stack.pop();
            int prevSmaller = !stack.isEmpty() ? stack.peek():-1;
            maxArea = Math.max(maxArea, heights[element]*(nextSmaller - prevSmaller -1));
        }
        return maxArea;
    }
}