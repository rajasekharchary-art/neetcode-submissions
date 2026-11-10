class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, new ArrayList<Integer>(), 0);
        return result;
    }

    private void combinationSum2(int[] candidates, int target, int currentSum, List<Integer> currentList, int startIndex) {
        if(currentSum == target) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        if (currentSum > target) {
            return;
        }

        for(int i = startIndex; i < candidates.length; i++) {
            if(i > startIndex && candidates[i] == candidates[i-1]) {
                continue;
            }
            currentList.add(candidates[i]);
            combinationSum2(candidates, target, currentSum + candidates[i], currentList, i + 1);
            currentList.remove(currentList.size() - 1);
        }

        
    }


}
