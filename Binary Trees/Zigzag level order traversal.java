class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true; 
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> row = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                if(leftToRight) 
                    row.add(curr.val);
                else 
                    row.add(0, curr.val); 
                if(curr.left != null) 
                    queue.add(curr.left);
                if(curr.right != null)  
                    queue.add(curr.right);
            }
            ans.add(row);
            leftToRight = !leftToRight;
        }
        return ans;
    }
}