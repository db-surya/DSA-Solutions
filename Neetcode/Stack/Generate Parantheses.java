class Solution {
    public void generate(StringBuilder sb, List<String>ans, int open, int close, int n){
        if(open==n && close==n){
            ans.add(sb.toString());
            return;
        }
        if(open<n){
            sb.append('(');
            generate(sb,ans,open+1,close,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(')');
            generate(sb,ans,open,close+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String>ans = new ArrayList<>();
        generate(sb,ans,0,0,n);
        return ans;
    }
}