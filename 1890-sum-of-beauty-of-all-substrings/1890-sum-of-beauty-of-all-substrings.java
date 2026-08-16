class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n; i++){
            int[] freq = new int[26];

            for(int j = i; j < n; j++){
                freq[s.charAt(j) - 'a']++;

                int maxfreq = 0;
                int minfreq = Integer.MAX_VALUE;

                for(int f : freq){
                    if(f > 0){
                        maxfreq = Math.max(maxfreq, f);
                        minfreq = Math.min(minfreq, f);
                    }
                }
                ans += (maxfreq - minfreq);
            }
        }
        return ans;
    }
}