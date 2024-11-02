class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        char a[] = s.toCharArray();
        int start =0;
        int end = a.length-1;
        while(start<end)
        {
            if(Character.isLetterOrDigit(a[start]) && Character.isLetterOrDigit(a[end]))
            {
                if(a[start]!=a[end])
                {
                    System.out.print(a[start]+" "+a[end]);
                    return false;
                }
                start++;
                end--;
            }
            if(!(Character.isLetterOrDigit(a[start])))
                start++;
            if(!(Character.isLetterOrDigit(a[end])))
                end--;
        }
        System.out.print(a[start]+""+a[end]);
        if(a[start]!=a[end] && (Character.isLetterOrDigit(a[start]) && Character.isLetterOrDigit(a[end])))
            return false;
        return true;
    
    }
}