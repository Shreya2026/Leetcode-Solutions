/*class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Character> list=new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b)->map.get(b)-map.get(a));
        StringBuilder sb=new StringBuilder();
        for(char ch:list){
            int freq=map.get(ch);
            for(int i=0;i<freq;i++){
                sb.append(ch);
            }
        }
        return sb.toString();

    }
}*/


//better solution priority queue
/*class Solution {
    public String frequencySort(String s) {
       Map<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        PriorityQueue<Character> maxHeap=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        maxHeap.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            char ch=maxHeap.poll();
            int freq=map.get(ch);
            while(freq-->0){
                sb.append(ch);
            }
        }
        return sb.toString(); 
    }
}*/

//optimal solution bucket sort
class Solution {
    public String frequencySort(String s) {
       Map<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        List<Character>[] buckets=new List[s.length()+1];
        for(char c:map.keySet()){
            int freq=map.get(c);
            if(buckets[freq]==null){
                buckets[freq]=new ArrayList<>();
            }
            buckets[freq].add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=buckets.length-1;i>=0;i--){
            if(buckets[i]!=null){
                for(char c:buckets[i]){
                    for(int j=0;j<i;j++){
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString(); 
    }
}