class BSTIterator{
    Stack<TreeNode>stack = new Stack<>();
    BSTIterator(TreeNode root,boolean isReverse){
        pushAll(root,isReverse);
    }
    public void pushAll(TreeNode root, boolean isReverse){
        TreeNode temp = root;
        if(!isReverse){
            while(temp!=null)
            {
                stack.push(temp);
                temp = temp.left;
            }
        }
        else{
            while(temp!=null){
                stack.push(temp);
                temp = temp.right;
            }
        }
    }
    public int next(boolean isReverse){
        TreeNode temp = stack.pop();
        if(!isReverse)
            pushAll(temp.right,false);
        else
            pushAll(temp.left,true);
        return temp.val;
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator left = new BSTIterator(root,false);
        BSTIterator right = new BSTIterator(root,true);
        int l = left.next(false);
        int r = right.next(true);
        while(l<r){
            if(l+r==k)
                return true;
            else if(l+r<k)
                l = left.next(false);
            else    
                r = right.next(true);
        }
        return false;
    }
}