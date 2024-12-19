class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = inorderPreorder(inorder,0,inorder.length-1,
        preorder,0,preorder.length-1,map);
        return root;
    }
    public TreeNode inorderPreorder(int[] inorder,int inStart,int inEnd,
    int[] preorder,int preStart,int preEnd,HashMap<Integer,Integer>map){
        if(inStart>inEnd || preStart>preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(preorder[preStart]);
        int numsLeft = inRoot-inStart;
        root.left = inorderPreorder(inorder,inStart,inRoot-1,preorder,
        preStart+1,preStart+numsLeft,map);
        root.right = inorderPreorder(inorder,inRoot+1,inEnd,
        preorder,preStart+numsLeft+1,preEnd,map);
        return root;
    }
}