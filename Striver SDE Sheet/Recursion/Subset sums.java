//User function Template for Java//User function Template for Java
class Solution{
    void func(int index, int sum, ArrayList<Integer>arr, ArrayList<Integer>ans, int N)
    {
        if(index == N)
        {
            ans.add(sum);
            return;
        }
        //picking
        func(index+1, sum+arr.get(index),arr,ans,N);
        //not picking
        func(index+1, sum, arr, ans, N);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        func(0,0,arr,ans,N);
        Collections.sort(ans);
        return ans;
    }
}