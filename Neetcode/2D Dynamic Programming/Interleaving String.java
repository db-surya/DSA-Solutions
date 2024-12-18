class Solution {
    public boolean checkInterleave(int l1, int l2, char[] s1, char[] s2, char[] s3, Boolean[][] memo){
        int l3 = l1+l2;
        if(l3>=s3.length) return true;
        if(memo[l1][l2]!=null) return memo[l1][l2];
        boolean result = false;
        if(l1<s1.length && l2<s2.length && s1[l1]==s3[l3] && s2[l2]==s3[l3]){
            result = checkInterleave(l1+1,l2,s1,s2,s3,memo) || checkInterleave(l1,l2+1,s1,s2,s3,memo);
        }
        else if(l1<s1.length && s1[l1]==s3[l3]){
            result =  checkInterleave(l1+1,l2,s1,s2,s3,memo);
        }
        else if(l2<s2.length && s2[l2]==s3[l3]){
            result = checkInterleave(l1,l2+1,s1,s2,s3,memo);
        }
        else{
            result = false;
        }
        memo[l1][l2] = result;
        return result;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        Boolean memo[][] = new Boolean[s1.length()+1][s2.length()+1];
        return checkInterleave(0,0,s1.toCharArray(),s2.toCharArray(),s3.toCharArray(),memo);
    }
}