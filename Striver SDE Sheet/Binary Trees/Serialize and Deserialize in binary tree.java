public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode>queue = new LinkedList<>();
        StringBuilder str = new StringBuilder();    
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            if(curr==null){
                str.append("X ");
                continue;
            }
            str.append(curr.val+" ");
            queue.add(curr.left);
            queue.add(curr.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        String values[] = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        for(int i=1;i<values.length;i++){
            TreeNode parent = queue.remove();
            if(!values[i].equals("X")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);    
            }
            if(!values[++i].equals("X")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}