class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>>map = new HashMap<>();
        for(String str : strs)
        {
            int count[] = new int[26];
            for(char c: str.toCharArray())
            {
                count[c-'a']+=1;
            }
            String s = "";
            for(int i=0;i<count.length;i++)
            {
                if(count[i]!=0)
                    s+= count[i]+""+i+" ";
            }
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            System.out.println(s+" "+list);
            map.put(s,list);
        }
        List<List<String>> ans = new ArrayList<>();
        map.forEach((key, value) -> {
            ans.add(value);
        });
        return ans;
    }
}