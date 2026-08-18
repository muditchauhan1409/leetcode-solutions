class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int curstart = intervals[i][0];
            int curend = intervals[i][1];
            if(curstart <= end){
                end = Math.max(end, curend);
            }
            else{
                ans.add(new int[]{start, end});
                start = curstart;
                end = curend;
            }
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[ans.size()][]);

        
    }
}