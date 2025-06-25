/*class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map=new HashMap<>();
        Set<Character> mapped=new HashSet<>();
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            char chS=s.charAt(i);
            char chT=t.charAt(i);
            if(map.containsKey(chS)){
                if(map.get(chS)!=chT) return false;
            }else{
                if(mapped.contains(chT)){
                    return false;
                } 
                map.put(chS,chT);
                mapped.add(chT);
            }

        }
        return true;
    }
}*/


class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> mapST=new HashMap<>();
        Map<Character,Character> mapTS=new HashMap<>();

        if(s.length()!=t.length()) return false;

        for(int i=0;i<s.length();i++){
            char chS=s.charAt(i);
            char chT=t.charAt(i);
            if(mapST.containsKey(chS)){
                if(mapST.get(chS)!=chT) return false;
            }else{
                mapST.put(chS,chT);
            }

            if(mapTS.containsKey(chT)){
                if(mapTS.get(chT)!=chS) return false;
            }else{
                mapST.put(chT,chS);
            }
    }
    return true;
}
}
