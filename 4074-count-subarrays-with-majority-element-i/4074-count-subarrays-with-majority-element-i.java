class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int ans = 0;
        for(int start = 0; start < nums.length; start++){
            int countTarget = 0;

            for(int end = start; end < nums.length; end++){
                if (nums[end] == target){
                    countTarget++;
                }

                int length = end - start + 1;

                if(countTarget > length / 2){
                    ans++;
                }
            }
        }
        return ans;
    }
}