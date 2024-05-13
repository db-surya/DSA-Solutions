class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        int nge[] = new int[n2];
        Stack<Integer> stack = new Stack<>();
        for(int i=n2-1;i>=0;i--)
        {
            int curr = nums2[i];
            map.put(nums2[i],i);
            int ans = -1;
            while(!stack.isEmpty() && stack.peek() <= curr)
            {
                stack.pop();
            }
            if(!stack.isEmpty())
            {
                ans = stack.peek();  
            }
            stack.push(curr);
            nge[i]=ans;
        }
        int ans[] = new int[n1];
        for(int i=0;i<n1;i++)
        {
            int index = map.get(nums1[i]);
            ans[i] = nge[index];
        }
        return ans;
    }
}
