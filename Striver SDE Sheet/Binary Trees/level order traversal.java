class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode>queue = new LinkedList();
        if(root!=null)queue.add(root);
        List<List<Integer>>ans = new LinkedList<>();
        while(!queue.isEmpty()){
            List<Integer>level = new LinkedList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.remove();
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
                level.add(curr.val);                
            }
            ans.add(level);
        }
        return ans;
    }
}