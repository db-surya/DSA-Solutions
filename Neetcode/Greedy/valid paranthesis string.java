class Solution {
    public boolean checkValidString(String s) {
        int min = 0, max = 0;
        for(char c:s.toCharArray()){
            if(c=='('){
                min++;
                max++;
            }else if(c==')'){
                min--;
                max--;
            }else{
                min--;
                max++;
            }
            if(min<0) min = 0;
            if(max<0) return false;
        }
        return min==0;
    }
}

/*
 * Since dealing with only one paranthesis we can go with count technique
 * if at any point min goes less than zero means we can make it 0
 * but if max goes less than 0 then it's a problem
 */