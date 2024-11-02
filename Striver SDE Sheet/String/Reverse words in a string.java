class Solution {
    public String reverseWords(String s) {
      int n = s.length();
      int start = n-1;
      int end = n;
      String ans = "";
      while(start>=-1)
      {
          if(start==-1 || (s.charAt(start)== ' ' && start!=n-1 ))
          {
              if(s.charAt(start+1)!=' ')
              {
                if(ans.length()!=0)
                    ans+=' ';
                for(int i=start+1;i<end;i++)
                {
                    ans+= s.charAt(i);
                }
             }
              end = start;
              start--;
          }
          else if(s.charAt(start)==' ')
          {
              end = start;
              start--;
          }
          else 
          {
              start--;
          }
      }
      return ans;
    }
}