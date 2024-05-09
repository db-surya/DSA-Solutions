class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstCreate(preorder,Integer.MAX_VALUE,new int[]{0});
    }
    public TreeNode bstCreate(int[] preorder, int upperBound, int[]nodesCount){
        if(nodesCount[0]==preorder.length || preorder[nodesCount[0]]>upperBound) return null;
        TreeNode root = new TreeNode(preorder[nodesCount[0]++]);
        root.left = bstCreate(preorder,root.val,nodesCount);
        root.right = bstCreate(preorder,upperBound,nodesCount);
        return root;
    }
}
