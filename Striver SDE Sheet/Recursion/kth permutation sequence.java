class Solution {
    public String getPermutation(int n, int k) {
        String ans = "";
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for(int i=1;i<n;i++)
        {
            numbers.add(i);
            fact = fact*i;
        }
        numbers.add(n);
        k = k-1;
        while(true)
        {
            int current = numbers.get(k/fact);
            ans = ans+current;
            numbers.remove(k/fact);
            if(numbers.size()==0)
                break;
            k = k%fact;
            fact = fact/numbers.size();
        }
        return ans;
    }
}