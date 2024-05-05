class Pair{
    TreeNode root;
    int index;
    Pair(TreeNode _root, int _index){
        this.root = _root;
        this.index = _index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) 
            return 0;
        Queue<Pair>queue = new LinkedList<>();
        queue.add(new Pair(root,1));
        int ans = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            int firstValue = 0, lastValue = 0;
            for(int i=0;i<size;i++){
                Pair curr = queue.remove();
                TreeNode currRoot = curr.root;
                int currIndex = curr.index;
                if(i==0)
                    firstValue = currIndex;
                if(i==size-1)
                    lastValue = currIndex;
                if(currRoot.left!=null) 
                    queue.add(new Pair(currRoot.left,currIndex*2));
                if(currRoot.right!=null)
                    queue.add(new Pair(currRoot.right,(currIndex*2)+1));
            }
            ans =  Math.max(ans, (lastValue-firstValue)+1);
        }
        return ans;
    }
}