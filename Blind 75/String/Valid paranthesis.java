class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray())
        {
            if(c=='(' || c=='{' || c=='[')
                stack.push(c);
            else
            {                
                if(stack.isEmpty()) 
                    return false;
                char left = stack.pop();
                if(c == '}' && left =='{' || c==')' && left == '('
                || c==']' && left =='[')
                    continue;
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}