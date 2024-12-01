class Solution {
    public String multiply(String num1, String num2) {
        int n1=num1.length(), n2=num2.length();
        int pos[] = new int[n1+n2];
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int p1 = i+j;
                int p2 = i+j+1;
                int sum = mul+pos[p2];
                pos[p1]+= sum/10;
                pos[p2] = sum%10;
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int p:pos){
            if(ans.length()==0 && p==0){
               continue; 
            }else{
                ans.append(p);
            }
        }
        return ans.length()==0 ? "0" : ans.toString();
    }
}