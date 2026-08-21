class Solution {
    public String frequencySort(String s) {
        //hashmap and max heap ka use 
        //character ko prority que me dalenge frequency ke based par 
        //heighest frequency walo ko remove karte jaenge 
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        pq.addAll(map.keySet());

        StringBuilder ans = new StringBuilder();

        while(!pq.isEmpty()){
            char ch = pq.poll();
            int freq = map.get(ch);

            while(freq-- > 0){
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
//frequecy count O(n)
// heap operation O(k log k) k apna unique character 
// toatal O(n log k)