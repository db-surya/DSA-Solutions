class Solution {

    public String encode(List<String> strs) {
        String str = "";
        for(int i=0;i<strs.size();i++){
            String curr = strs.get(i);
            str+=curr.length()+"#"+curr;
        }
        return str;
    }

    public List<String> decode(String str) {
        char strArray[] = str.toCharArray();
        List<String>ans = new ArrayList<>(); 
        String number = "";
        int i=0;
        while(i<strArray.length){
            while(strArray[i]!='#'){
                number+=strArray[i];
                i++;
            }
            int num = Integer.parseInt(number);
            ans.add(str.substring(i+1,i+num+1));
            i+=num+1;
            number = "";
        }  
        return ans;
    }
}
