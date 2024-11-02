class Solution {
    public String getString(int num, int i, HashMap<Integer,String>belowTwenty, HashMap<Integer,String>aboveTwenty){
        String res="";
        String[] postFix = new String[]{"","Thousand","Million","Billion"};
        if(num/100>0){
            res+= belowTwenty.get(num/100)+" Hundred ";
        }
        num = num%100;
        if(num<20 && num>0){
            res+=belowTwenty.get(num)+" ";
        }
        else if(num>=20){
            int onesPlace = num%10;
            int tensPlace = (num/10)*10;
            if(tensPlace!=0) res+=aboveTwenty.get(tensPlace)+" ";
            if(onesPlace!=0) res+=belowTwenty.get(onesPlace)+" ";
        }
        if(res.length()>0)
            res+=postFix[i];
        return res;
    }

    public String numberToWords(int num) {
        if(num==0) return "Zero";
        StringBuilder ans = new StringBuilder();

        HashMap<Integer,String> belowTwenty = new HashMap<>();
        belowTwenty.put(1,"One");
        belowTwenty.put(2,"Two");
        belowTwenty.put(3,"Three");
        belowTwenty.put(4,"Four");
        belowTwenty.put(5,"Five");
        belowTwenty.put(6,"Six");
        belowTwenty.put(7,"Seven");
        belowTwenty.put(8,"Eight");
        belowTwenty.put(9,"Nine");
        belowTwenty.put(10,"Ten");
        belowTwenty.put(11,"Eleven");
        belowTwenty.put(12,"Twelve");
        belowTwenty.put(13,"Thirteen");
        belowTwenty.put(14,"Fourteen");
        belowTwenty.put(15,"Fifteen");
        belowTwenty.put(16,"Sixteen");
        belowTwenty.put(17,"Seventeen");
        belowTwenty.put(18,"Eighteen");
        belowTwenty.put(19,"Nineteen");

        HashMap<Integer,String> aboveTwenty = new HashMap<>();
        aboveTwenty.put(20,"Twenty");
        aboveTwenty.put(30,"Thirty");
        aboveTwenty.put(40,"Forty");
        aboveTwenty.put(50,"Fifty");
        aboveTwenty.put(60,"Sixty");
        aboveTwenty.put(70,"Seventy");
        aboveTwenty.put(80,"Eighty");
        aboveTwenty.put(90,"Ninety");

        int i = 0;
        while(num>0){
            String getStringResult = getString(num%1000,i,belowTwenty,aboveTwenty);
            if(!getStringResult.trim().isEmpty()){
            ans.insert(0, getStringResult+" ");
            }
            num = num/1000;
            i++;
        }
        String finalResult = ans.toString();
        return finalResult.trim();
    }
}