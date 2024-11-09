public class Solution {
    public String removeKdigits(String num, int k) {
        if(k>=num.length()) return "0";
        Stack<Character>stack = new Stack<>();
        for(char c: num.toCharArray()){
            if(stack.isEmpty()) stack.push(c);
            else{
                while(!stack.isEmpty() && stack.peek()-'a' > c-'a' && k>0){
                    k--;
                    stack.pop();
                }
                stack.push(c);
            }
        }
        String res = "";
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        StringBuilder sb = new StringBuilder(res);
        while(k>0){
            sb.deleteCharAt(0);
            k--;
        }
        sb.reverse();
        while(sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.length()>0 ? sb.toString() : "0";
    }
} {
    
}
