class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        // stack: [maxVal, startIdx, endIdx]
        Deque<int[]> stk = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int curMax = nums[i];
            int start = i;
            while (!stk.isEmpty() && stk.peek()[0] > nums[i]) {
                int[] top = stk.pop();
                curMax = Math.max(curMax, top[0]);
                start = top[1];
            }
            stk.push(new int[]{curMax, start, i});
        }

        for (int[] comp : stk) {
            for (int i = comp[1]; i <= comp[2]; i++) {
                ans[i] = comp[0];
            }
        }
        return ans;
    }
}