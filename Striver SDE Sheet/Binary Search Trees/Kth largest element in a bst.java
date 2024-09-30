class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
    int ans = 0, count = 0;
    public void kthLarge(Node root, int K){
        if(root==null) return;
        kthLarge(root.right,K);
        count++;
        if(count==K){
            ans = root.data;
            return;
        }
        kthLarge(root.left,K);
    }
    public int kthLargest(Node root,int K)
    {
        //Your code here
        kthLarge(root,K);
        return ans;
    }
}