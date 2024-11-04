class Solution {
    public int calculate(String s) {
        Stack<Integer>stack = new Stack();
        int number = 0;
        char operator = '+';
        int n =  s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = number*10+(c-'0');
            }
            if(!Character.isDigit(c) && c!=' ' || i==n-1){
                if(operator=='+') stack.push(number);
                if(operator=='-') stack.push(-1*number); 
                if(operator=='*') stack.push(stack.pop()*number);
                if(operator=='/') stack.push(stack.pop()/number);
                operator = c;
                number = 0;
            }
        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans+=stack.pop();
        }
        return ans;
    }
}

/*Notes
1. + and - are same preceedence
2. / and * are same precdeedence 
3. For same preceedence left to right is the preceedence
4. Iterate if + direct push, if - multiply by -1 and push
5. For * and / take the top one out perform operation and then push
/*