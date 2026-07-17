class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        backtrack(0, candidates, target, new ArrayList<>());
        return ans;
        
    }
    private void backtrack(int start, int[] candidate, int target, List<Integer> current){
        if(target == 0){
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i < candidate.length; i++){
            if (candidate[i] > target)
            break;

            current.add(candidate[i]);

            backtrack(i, candidate, target - candidate[i], current);

            current.remove(current.size() -1);
        }
    }
}