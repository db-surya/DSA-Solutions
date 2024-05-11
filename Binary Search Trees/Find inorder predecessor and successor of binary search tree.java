public static void findPreSuc(Node root, int key)
{
    // code here.
    
    /* There are two static nodes defined above pre(representing predecessor) and suc(representing successor) as follows:
       static Node pre=null,suc=null
       You need to update these both.
       And the data inside these classes will be printed automatically by the driver code. 
    */
    if(root==null) return;
    if(root.data == key){
        //Find predecessor by traversing atmost right of left
        if(root.left!=null){
            Node temp = root.left;
            while(temp.right!=null){
                temp = temp.right;
            }
            pre = temp;
        }
        if(root.right!=null){
            Node temp = root.right;
            while(temp.left!=null){
                temp = temp.left;
            }
            suc = temp;
        }
        return;
    }
    if(root.data < key){
        pre = root;
        findPreSuc(root.right,key);
    }
    else{
        suc = root;
        findPreSuc(root.left,key);
    }
}
}