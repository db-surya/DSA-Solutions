import java.util.*;
public class Solution {
    public static void printAllPaths(BinaryTreeNode root,String str, List<String>ans){
        if(root==null){
            return;
        }
        str+=root.data+" ";
        if(root.left==null && root.right==null){
            str = str.substring(0,str.length()-1);
            ans.add(str);
        }
        printAllPaths(root.left,str,ans);
        printAllPaths(root.right,str,ans);
        str = str.substring(0,str.length()-String.valueOf(root.data).length()+1);
    }
    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        // Write your code here.
        String str = "";
        List<String>ans = new ArrayList<>();
        printAllPaths(root,str,ans);
        return ans;
    }
}